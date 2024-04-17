
CREATE TABLE IF NOT EXISTS farm (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    location VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS field (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    farm_id BIGINT NOT NULL,
    planting_area DOUBLE NOT NULL,
    FOREIGN KEY (farm_id) REFERENCES farm(id)
);

CREATE TABLE IF NOT EXISTS crop_type (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS season (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL
);

CREATE TABLE IF NOT EXISTS planting (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    field_id BIGINT NOT NULL,
    season_id BIGINT NOT NULL,
    crop_type_id BIGINT NOT NULL,
    expected_product_amount DOUBLE NOT NULL,
    FOREIGN KEY (field_id) REFERENCES field(id),
    FOREIGN KEY (season_id) REFERENCES season(id),
    FOREIGN KEY (crop_type_id) REFERENCES crop_type(id)
);

CREATE TABLE IF NOT EXISTS harvest (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    planting_id BIGINT NOT NULL,
    actual_harvested_amount DOUBLE NOT NULL,
    FOREIGN KEY (planting_id) REFERENCES planting(id)
);

-- Sample data for farms
INSERT INTO farm (name, location) VALUES
('Farm A', 'Location A'),
('Farm B', 'Location B'),
('Farm C', 'Location C');

-- Sample data for fields
INSERT INTO field (farm_id, planting_area) VALUES
(1, 10.5),
(1, 8.2),
(2, 15.0),
(3, 12.3);

-- Sample data for crop types
INSERT INTO crop_type (name) VALUES
('Corn'),
('Wheat'),
('Soybean'),
('Rice');

-- Sample data for seasons in 2024
INSERT INTO season (name, start_date, end_date) VALUES
('Spring 2024', '2024-03-20', '2024-06-20'),
('Summer 2024', '2024-06-21', '2024-09-22'),
('Autumn 2024', '2024-09-23', '2024-12-21'),
('Winter 2024', '2024-12-22', '2025-03-19');