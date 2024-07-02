# Bluetooth Finder

Bluetooth Finder is an Android application that allows you to discover nearby devices with Bluetooth enabled. It provides a simple interface to scan for Bluetooth devices, displaying their names (if available), MAC addresses, and signal strength (RSSI) in decibels (dBm).

## Table of Contents

* [Features](#features)
* [Installation](#installation)
  * [Prerequisites](#prerequisites)
  * [Steps](#steps)
* [Usage](#usage)
* [Screenshots](#screenshots)
* [Technologies Used](#technologies-used)
* [Contributing](#contributing)
* [Contact](#contact)

## Features

- Scan for nearby Bluetooth devices.
- Display device names (if available), MAC addresses, and signal strength.
- Automatically update the list as new devices are found.
- Simple and intuitive user interface.

## Installation

### Prerequisites

Before you begin, ensure you have met the following requirements:

- An Android device with Bluetooth capability.
- Android Studio installed on your computer.
- Basic understanding of Android development and permissions.

### Steps

1. **Clone the repository:**

    ```bash
    git clone https://github.com/yourusername/bluetooth-finder.git
    ```

2. **Open the project in Android Studio:**

    - Open Android Studio.
    - Click on `Open an existing project`.
    - Navigate to the cloned repository and select it.

3. **Run the app:**

    - Connect your Android device via USB or start an emulator.
    - Click the `Run` button (green play icon) in Android Studio.
    - The app should now be installed and running on your device/emulator.

## Usage

1. Open the Bluetooth Finder app on your Android device.
2. Click the "Search" button to start scanning for nearby Bluetooth devices.
3. The app will display a list of discovered devices with their details.
4. Each device entry includes its name (if available), MAC address, and signal strength (RSSI in dBm).
5. To stop scanning, click the "Search" button again or wait until the scan completes automatically.

## Screenshots

![Bluetooth finder (1)](https://github.com/kanak27/Bluetooth-Finder/assets/83486327/bfb625e4-d34b-4d25-82df-f92c1d817608)


*List of discovered Bluetooth devices.*

## Technologies Used

- **Language:** Kotlin
- **Framework:** Android SDK
- **Bluetooth API:** Android BluetoothAdapter, BluetoothDevice
- **UI Design:** XML
- **ListView Adapter:** ArrayAdapter

## Contributing

We welcome contributions! Please follow these steps:

1. Fork the repository.
2. Create your feature branch (`git checkout -b feature/YourFeature`).
3. Commit your changes (`git commit -m 'Add some feature'`).
4. Push to the branch (`git push origin feature/YourFeature`).
5. Open a pull request.

    Please ensure your changes are well-documented and tested.

## Contact

Have questions or feedback? Reach out to us:

- Email: kanaklohiya.lohiya@gmail.com

---

Thank you for using Bluetooth Finder! We hope you find it useful and convenient to discover nearby Bluetooth devices.

---
