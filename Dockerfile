FROM maven:3.9.6-eclipse-temurin-17-alpine

# Set working directory
WORKDIR /app

# Copy only POM first to leverage Docker cache
COPY pom.xml .

# Download dependencies
RUN mvn dependency:go-offline -B

# Copy remaining source files
COPY src ./src

# Install Chrome dependencies and Chrome itself
RUN apk add --no-cache \
    chromium \
    nss \
    freetype \
    harfbuzz \
    ca-certificates \
    ttf-freefont \
    && rm -rf /var/cache/apk/*

# Set Chrome path
ENV CHROME_BIN=/usr/bin/chromium-browser

# Create directories for test outputs
RUN mkdir -p /app/target/surefire-reports \
    && mkdir -p /app/logs

# Run tests
CMD ["mvn", "test", "-DsuiteXmlFile=src/test/resources/testng.xml"]