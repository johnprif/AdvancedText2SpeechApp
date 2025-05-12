# AdvancedText2SpeechApp

> A Java Swing desktop application that loads, edits and converts documents (Word .docx, Excel .xlsx, etc.) into spoken audio using the FreeTTS library. It employs Factory, Decorator and Facade design patterns to structure document parsing, UI logic and TTS conversion, and is packaged as a Windows .exe.

[Download Latest Release (Windows Executable)](https://github.com/johnprif/AdvancedText2SpeechApp/releases/tag/Stable)

## 📋 Table of Contents
1. [Overview](#overview)  
2. [Features](#features)  
3. [Screenshots](#screenshots)  
4. [Technologies](#technologies)  
5. [Installation](#installation)  
6. [Usage](#usage)  
7. [Architecture](#architecture)  
8. [Contributing](#contributing)  
9. [License](#license)  
10. [Contact](#contact)  

## Overview

AdvancedText2SpeechApp is a **stand‑alone** Java 11 application with a Swing GUI that enables users to open, edit and convert text from multiple document formats into audio via FreeTTS. It supports Microsoft Word (.docx) and Excel (.xlsx) through Apache POI, applies encoding/decoding for privacy, and uses proven design patterns (Factory, Decorator, Facade) to decouple components and simplify extension.

## Features

- **Multi‑format input**: Load `.docx` and `.xlsx` files via Apache POI for Word and Excel support.  
- **Text editing**: Built‑in editor allows modifying document text prior to speech synthesis.  
- **TTS conversion**: Uses FreeTTS, a pure‑Java speech synthesizer based on CMU Flite, for offline text‑to‑speech.  
- **Design patterns**:  
  - **Factory** to instantiate document parsers dynamically.  
  - **Decorator** to layer encoding/decoding or text preprocessing.  
  - **Facade** to expose a simple API for UI to trigger complex back‑end workflows.  
- **Accessibility‑focused**: Packaged as Windows .exe for easy launch.  

## Screenshots

<p align="center">  
  <img src="https://user-images.githubusercontent.com/56134761/210150536-743f37ba-87c2-49cf-a1e4-fc11ce2146fa.png" alt="Main GUI view" width="400"/>  
</p>

## Technologies

| Component         | Technology / Library                             |
|-------------------|---------------------------------------------------|
| Language          | Java 11                                            |
| GUI               | Java Swing                                        |
| Document I/O      | Apache POI (poi‑5.0.0)          |
| Speech Synthesis  | FreeTTS 1.2.2                 |
| Build & Packaging | Eclipse 2022‑06, packaged as `.exe` via launch4j |
| Design Patterns   | Factory, Decorator, Facade |

## Installation

1. **Download the latest release** from the [Releases page](https://github.com/johnprif/AdvancedText2SpeechApp/releases)  
2. **Run the installer** or unzip the `.exe` package; no additional dependencies required.  
3. **Ensure Java 11+** is installed on your machine (bundled JRE if provided).  

## Usage

1. **Launch** `AdvancedText2SpeechApp.exe`.  
2. **Open** a Word (`.docx`) or Excel (`.xlsx`) file via **Open**.  
3. **Edit** text in the built‑in editor pane as needed.  
4. **Convert to audio**: click **Speak** or **Export WAV** to generate spoken output.  
5. **Adjust voice settings** (rate, pitch) under **Options** before synthesis.  

## Architecture

```plaintext
+--------------+      +-------------+      +-----------------+
| Swing GUI    | <--> | Controller  | <--> | Text2Speech API |
+--------------+      +-------------+      +-----------------+
                             |
                             v
                   +---------------------+
                   | Document Parser     |
                   | (Apache POI Factory) |
                   +---------------------+
```
- **Facade** exposes a simple `synthesize(text)` interface to the GUI. 
- **Factory** creates the appropriate parser (WordParser, ExcelParser) at runtime.
- **Decorator** wraps parsed text with encoding/decoding layers for privacy.

## Contributing
Contributions are welcome:
1. Fork the repo
2. Create a branch: `git checkout -b feature/MyFeature`
3. Commit: `git commit -m "Add MyFeature"`
4. Push: `git push origin feature/MyFeature`
5. Open a Pull Request

## License
This project is released under the **MIT License**. See [LICENSE](https://github.com/johnprif/AdvancedText2SpeechApp/blob/main/LICENSE) for full text.

## Contact
- GitHub: [johnprif](https://github.com/johnprif)
- Email: [giannispriftis37@gmail.com](mailto:giannispriftis37@gmail.com)
- Phone: [+306940020178](tel:+306940020178)

---

*Made with ♡ for accessible, offline text‑to‑speech.*
