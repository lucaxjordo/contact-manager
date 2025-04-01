-- Disable foreign key checks temporarily to avoid constraint errors during setup
SET FOREIGN_KEY_CHECKS = 0;

-- Clear tables and reset auto-increment counters
TRUNCATE TABLE phones;
TRUNCATE TABLE contacts;

-- Re-enable foreign key checks
SET FOREIGN_KEY_CHECKS = 1;

-- Create tables if they don't exist (with explicit ENGINE and CHARSET)
CREATE TABLE IF NOT EXISTS contacts (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    created_at DATETIME(6) DEFAULT CURRENT_TIMESTAMP(6),
    updated_at DATETIME(6) DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE IF NOT EXISTS phones (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    number VARCHAR(20) NOT NULL,
    contact_id BIGINT NOT NULL,
    CONSTRAINT fk_contact FOREIGN KEY (contact_id) REFERENCES contacts (id) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Insert contacts (using explicit ID values to ensure consistency)
INSERT INTO contacts (id, name, email, created_at, updated_at) VALUES
(1, 'Tony Stark', 'tony.stark@starkindustries.com', NOW(), NOW()),
(2, 'Steve Rogers', 'steve.rogers@avengers.com', NOW(), NOW()),
(3, 'Natasha Romanoff', 'natasha@shield.gov', NOW(), NOW()),
(4, 'Bruce Banner', 'hulk@gamma.com', NOW(), NOW()),
(5, 'Peter Parker', 'spidey@dailybugle.com', NOW(), NOW());

-- Insert phone numbers with guaranteed correct foreign key references
INSERT INTO phones (number, contact_id) VALUES
('(11) 99999-9999', 1),
('(21) 98888-8888', 1),
('(31) 97777-7777', 2),
('(41) 96666-6666', 3),
('(51) 95555-5555', 4),
('(61) 94444-4444', 5);