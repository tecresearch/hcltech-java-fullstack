/*
1. String Data Types

CHAR(n): Fixed-length string with a length of n characters. Padding with spaces if the input is shorter than n.
VARCHAR(n): Variable-length string with a maximum length of n characters.
TEXT: Large text data; used for storing long strings.
TINYTEXT: Very small text data (maximum 255 characters).
MEDIUMTEXT: Medium-length text data.
LONGTEXT: Large text data; used for extremely long strings.
NCHAR(n): Fixed-length Unicode string.
NVARCHAR(n): Variable-length Unicode string.
NTEXT: Unicode text data (deprecated in some DBMSs like SQL Server).

2. Numeric Data Types

Exact Numeric Data Types
INT (or INTEGER): Whole numbers (commonly 4 bytes).
SMALLINT: Small-range integers.
BIGINT: Large-range integers.
TINYINT: Very small-range integers (0-255 or -128 to 127).
DECIMAL(p, s) (or NUMERIC(p, s)): Fixed-point numbers with precision p and scale s.
BIT: Stores binary values (0 or 1).
Approximate Numeric Data Types
FLOAT(p): Floating-point number; precision p is optional.
REAL: Similar to FLOAT; may have platform-specific differences.
DOUBLE PRECISION: Higher precision than FLOAT.

3. Date and Time Data Types

DATE: Stores dates (YYYY-MM-DD).
DATETIME: Stores date and time (YYYY-MM-DD HH:MM:SS).
TIMESTAMP: Stores date and time, often used for tracking changes.
TIME: Stores time (HH:MM:SS).
YEAR: Stores a year as a 4-digit number.

4. Binary Data Types

BINARY(n): Fixed-length binary data.
VARBINARY(n): Variable-length binary data with a maximum length of n.
BLOB (Binary Large Object): Used to store large binary data like images or files.
TINYBLOB: Small binary data.
MEDIUMBLOB: Medium binary data.
LONGBLOB: Large binary data.

5. JSON and Spatial Data Types

JSON: Stores JSON-formatted data (supported in MySQL, PostgreSQL, etc.).
GEOMETRY: Stores spatial data like points, lines, and polygons.
POINT: Stores a single point in a coordinate system.
LINESTRING: Stores a sequence of points that form a line.
POLYGON: Stores shapes.

6. Special Data Types (DBMS-Specific)

ENUM: A predefined list of values (e.g., ENUM('small', 'medium', 'large')).
SET: A string object that can hold multiple predefined values (used in MySQL).
XML: Stores XML data (used in SQL Server, PostgreSQL, etc.).
UUID: Universally Unique Identifier for storing unique keys (e.g., GUID in SQL Server).
ARRAY: Stores arrays of data (supported in PostgreSQL).
MONEY or CURRENCY: Stores monetary values (e.g., SQL Server).
Category-Specific Usage Notes
String Types: Use VARCHAR or TEXT for strings. For Unicode, use NVARCHAR.
Numeric Types: Choose based on range and precision. Use DECIMAL for precise calculations.
Date and Time: Use DATETIME or TIMESTAMP for timestamps.
Binary and Special Types: Use BLOB for multimedia and JSON for structured data.*/