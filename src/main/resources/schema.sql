
-- Create Farm table
CREATE TABLE Farm (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL
);

-- Create Season table
CREATE TABLE IF NOT EXISTS Season (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    season_year INT NOT NULL,
    name VARCHAR(255) NOT NULL,
    farm_id BIGINT,
    FOREIGN KEY (farm_id) REFERENCES Farm(id)
);

CREATE TABLE IF NOT EXISTS Field (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    crop_type VARCHAR(255),
    planting_area DOUBLE,
    expected_product DOUBLE,
    actual_product DOUBLE,
    season_id BIGINT,
    FOREIGN KEY (season_id) REFERENCES Season(id)
);

-- Insert sample data for farms
INSERT INTO Farm (name) VALUES
        ('Farm A'),
        ('Farm B'),
        ('Farm C'),
        ('Farm D'),
        ('Farm E'),
        ('Farm F'),
        ('Farm G'),
        ('Farm H'),
        ('Farm I'),
        ('Farm J'),
        ('Farm K'),
        ('Farm L'),
        ('Farm M'),
        ('Farm N'),
        ('Farm O'),
        ('Farm P'),
        ('Farm Q'),
        ('Farm R'),
        ('Farm S'),
        ('Farm T');

-- Insert sample data for seasons
INSERT INTO Season (season_year, name, farm_id) VALUES
        (2023, 'Spring', 1),
        (2023, 'Summer', 2),
        (2023, 'Autumn', 3),
        (2023, 'Winter', 4),
        (2023, 'Spring', 5),
        (2023, 'Summer', 6),
        (2023, 'Autumn', 7),
        (2023, 'Winter', 8),
        (2023, 'Spring', 9),
        (2023, 'Summer', 10),
        (2023, 'Autumn', 11),
        (2023, 'Winter', 12),
        (2023, 'Spring', 13),
        (2023, 'Summer', 14),
        (2023, 'Autumn', 15),
        (2023, 'Winter', 16),
        (2023, 'Spring', 17),
        (2023, 'Summer', 18),
        (2023, 'Autumn', 19),
        (2023, 'Winter', 20);

-- Insert sample data for fields
INSERT INTO Field (crop_type, planting_area, expected_product, actual_product, season_id) VALUES
        ('Corn', 50.0, 100.0, 80.0, 1),
        ('Wheat', 30.0, 60.0, 55.0, 1),
        ('Rice', 40.0, 80.0, 75.0, 1),
        ('Corn', 45.0, 90.0, 85.0, 2),
        ('Wheat', 35.0, 70.0, 65.0, 2),
        ('Rice', 50.0, 100.0, 95.0, 2),
        ('Corn', 60.0, 120.0, 110.0, 3),
        ('Wheat', 40.0, 80.0, 75.0, 3),
        ('Rice', 55.0, 110.0, 105.0, 3),
        ('Corn', 55.0, 110.0, 100.0, 4),
        ('Wheat', 45.0, 90.0, 85.0, 4),
        ('Rice', 60.0, 120.0, 115.0, 4),
        ('Corn', 65.0, 130.0, 125.0, 5),
        ('Wheat', 50.0, 100.0, 95.0, 5),
        ('Rice', 70.0, 140.0, 135.0, 5),
        ('Corn', 70.0, 140.0, 130.0, 6),
        ('Wheat', 55.0, 110.0, 105.0, 6),
        ('Rice', 75.0, 150.0, 145.0, 6),
        ('Corn', 80.0, 160.0, 155.0, 7),
        ('Wheat', 60.0, 120.0, 115.0, 7),
        ('Rice', 85.0, 170.0, 165.0, 7),
        ('Corn', 85.0, 170.0, 160.0, 8),
        ('Wheat', 65.0, 130.0, 125.0, 8),
        ('Rice', 90.0, 180.0, 175.0, 8),
        ('Corn', 95.0, 190.0, 180.0, 9),
        ('Wheat', 70.0, 140.0, 135.0, 9),
        ('Rice', 100.0, 200.0, 195.0, 9),
        ('Corn', 100.0, 200.0, 190.0, 10),
        ('Wheat', 75.0, 150.0, 145.0, 10),
        ('Rice', 110.0, 220.0, 215.0, 10),
        ('Corn', 110.0, 220.0, 210.0, 11),
        ('Wheat', 80.0, 160.0, 155.0, 11),
        ('Rice', 120.0, 240.0, 235.0, 11),
        ('Corn', 120.0, 240.0, 230.0, 12),
        ('Wheat', 85.0, 170.0, 165.0, 12),
        ('Rice', 130.0, 260.0, 255.0, 12),
        ('Corn', 130.0, 260.0, 250.0, 13),
        ('Wheat', 90.0, 180.0, 175.0, 13),
        ('Rice', 140.0, 280.0, 275.0, 13),
        ('Corn', 140.0, 280.0, 270.0, 14),
        ('Wheat', 95.0, 190.0, 185.0, 14),
        ('Rice', 150.0, 300.0, 295.0, 14),
        ('Corn', 150.0, 300.0, 290.0, 15),
        ('Wheat', 100.0, 200.0, 195.0, 15),
        ('Rice', 160.0, 320.0, 315.0, 15),
        ('Corn', 160.0, 320.0, 310.0, 16),
        ('Wheat', 105.0, 210.0, 205.0, 16);