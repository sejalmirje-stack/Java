-- Database setup script for Experiment 4
CREATE DATABASE IF NOT EXISTS empdb;
USE empdb;

CREATE TABLE IF NOT EXISTS employee (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    department VARCHAR(50),
    salary DOUBLE
);

-- Sample Data (Optional)
INSERT INTO employee (name, email, department, salary) VALUES
('John Doe', 'john.doe@example.com', 'IT', 75000.00),
('Jane Smith', 'jane.smith@example.com', 'HR', 65000.00);
