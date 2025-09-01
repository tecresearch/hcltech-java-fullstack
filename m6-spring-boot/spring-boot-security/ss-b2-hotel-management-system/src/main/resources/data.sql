-- Insert some sample data into Hotel table
INSERT INTO hotel (id, name, address) VALUES (1, 'Luxury Inn', '123 Main Street');
INSERT INTO hotel (id, name, address) VALUES (2, 'Budget Stay', '456 Side Road');

-- Insert some sample data into Booking table
INSERT INTO booking (id, hotel_id, customer_name) VALUES (1, 1, 'John Doe');
INSERT INTO booking (id, hotel_id, customer_name) VALUES (2, 2, 'Jane Smith');
