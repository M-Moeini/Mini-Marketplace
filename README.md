# Mini-Marketplace

## Important Note
This project was built 3 years ago using Java, Spring Boot, and IntelliJ, tools. At the time, due to my lack of experience with version control, the code was directly pushed to GitHub without following proper CI/CD rules, incremental commits, or best practices. However, after 3 years of experience and growth in this tech stack, I now have sufficient knowledge to improve upon this project. I have decided to update the README and provide more detailed information to reflect the progress made on this incredible project.

## Overview

Mini-Marketplace is a mini online shop developed in both Monolithic and Microservice architectures using the MVC architectural pattern. It is built with the help of Spring Boot, JPA, Spring Security, and JWT. The project consists of two user panels: one for the website's admin and another for clients.

## Features

- **User Authentication**: Clients can sign in using JWT tokens.
- **Product Management**: Clients can choose products, sell their products, and like other products.
- **Profile Management**: Clients can edit their profiles.
- **Product Sorting**: Clients can sort products based on different criteria.
- **OTP Service**: An OTP service is available for additional security.
- **Admin Panel**: Admins have a dedicated panel to manage the website.

## Architecture


### MVC Microservice Architecture

The microservice architecture consists of three services:

1. **OTP Service**: Generates OTPs for the clients.
2. **Gateway Service**: Handles the login process.
3. **Business Service**: Manages the rest of the functionalities of the shop.

## Technology Stack

- **Spring Boot**
- **Spring Security**
- **JWT**
- **JPA**
- **MySQL**: Database management system.

## Installation

1. **Clone the repository**:
   ```bash
   git clone https://github.com/yourusername/mini-marketplace.git
   cd mini-marketplace


## Usage

### Client Panel
- **Sign In**: Clients can sign in using their credentials.
- **Product Selection**: Browse and select products.
- **Sell Products**: List products for sale.
- **Like Products**: Like other products.
- **Edit Profile**: Update personal information.
- **Sort Products**: Sort products based on various criteria.
- **OTP Service**: Use OTP for enhanced security.

### Admin Panel
- Manage users and products.

## Security
- **Spring Security**: Secures the application endpoints.
- **JWT**: Used for authentication between the pages.
- **OTP**: Provides an additional layer of security.

## Database
- **MySQL**: Used for storing user and product information.

## Contribution
Feel free to fork this repository and contribute by submitting a pull request. For major changes, please open an issue first to discuss what you would like to change.

## Contact
- **Mahdi Moeini**
  - **Email**: [mmoeini@mun.ca](mailto:mmoeini@mun.ca)
  - **LinkedIn**: [linkedin.com/in/mmoeini](https://linkedin.com/in/mmoeini)
  - **GitHub**: [m-moeini.github.io](https://m-moeini.github.io)

