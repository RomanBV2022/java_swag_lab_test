FROM maven:3.9.6-eclipse-temurin-17-alpine

# Set working directory
WORKDIR /app

# Copy
COPY . .



# Run tests
CMD ["mvn", "test", "-DsuiteXmlFile=src/test/resources/testng.xml"]