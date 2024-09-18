
# CodeHub - European Dynamics  
## XML Master  

In this application, you can manage XML files and perform various actions with them.

The app has been structured based on Use Cases driven by business requirements. Below, we will explore the architecture of each use case.

### Model Classes:

- **Book.class**
  - Fields:
    - `List<Chapter> chapters`: A list to store all chapters.
    - `Statistics statistics`: Stores statistics from the XML file.

- **Chapter.class**
  - Fields:
    - `int id`: Represents the chapter's ID.
    - `List<Paragraph> paragraphs`: A list of paragraphs.

- **Paragraph.class**
  - Fields:
    - `List<Sentence>`: A list of sentences.

- **Sentence.class**
  - Fields:
    - `String text`: The sentence text.

- **Statistics.class**
  - Fields:
    - Contains simple fields for input.

As you can see in the code, we use annotations from **Lombok** and **Jakarta**. Lombok helps with generating setters, getters, and constructors. Jakarta assists with XML creation and general XML functionalities.

### Use Cases:

#### 1. Txt To XML File
- **Service**: `TxtToXmlParser.java`  
  A parser that converts a TXT file to an XML file. It also generates statistics that are calculated during the conversion process.

#### 2. Read from Existing XML File
- **Service**: `ReadFromXml.java`  
  Accepts an XML file and a `List<Integer>` of chapter IDs as input. It reads the XML file line by line, splitting chapters, paragraphs, and sentences based on the chapter ID.

#### 3. Write to XML File
- **Service**: `WriteToXml.java`  
  Initially reads using `ReadFromXml.java`, then takes a `List<Element>` and the path where the file should be saved as input.

#### 4. Generate Statistics
- **Service**: `StatisticsOfXmlFile.java`  
  Generates statistics from an XML file by reading it line by line, based on the provided file path.

#### 5. Generate XSD File
- **Service**: `GenerateXsdFromModel.java`  
  Uses JAXB to create an XSD file based on the model.

#### 6. XML Validation
- Validates the XML file against the XSD file.

### How to Use

To run the project, ensure you have Java installed on your machine.

#### Clone the Repository:
```bash
git clone <repository-url>
```

#### Steps:

1. The first step is to run the **Txt to XML** use case.
2. Once that is done, you can run all the other use cases.
3. If you want to run the validation use case, you **must** first run the **Generate XSD File** use case.
4. Following this order will prevent any issues.

We hope you enjoy the application.

Thank you!
