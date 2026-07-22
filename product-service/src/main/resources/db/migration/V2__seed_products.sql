INSERT INTO products (
    id,
    sku,
    name,
    description,
    brand,
    category,
    price,
    stock_quantity,
    weight_kg,
    image_url,
    active,
    created_at,
    updated_at
)
VALUES
-- CPUs
('1b0d0fa6-52e1-4acd-8286-892bc29f8b3a', 'CPU-AMD-9800X3D', 'AMD Ryzen 7 9800X3D',
    '8-core gaming processor with 3D V-Cache.',
    'AMD', 'CPU', 899.99, 15, 0.12,
    '/images/products/amd-9800x3d.jpg', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

('e85d4dc8-de0f-41cb-a283-8d2de6ab82e6', 'CPU-INT-U7-265K', 'Intel Core Ultra 7 265K',
    'High-performance desktop processor.',
    'Intel', 'CPU', 749.99, 10, 0.12,
    '/images/products/intel-ultra7-265k.jpg', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- Graphics Cards
('f649098e-2fd6-4dcf-ad86-d19423f18a53', 'GPU-NV-5070TI', 'NVIDIA GeForce RTX 5070 Ti',
    'High-end graphics card for gaming and AI workloads.',
    'NVIDIA', 'Graphics Card', 1699.99, 6, 1.80,
    '/images/products/rtx5070ti.jpg', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

('c85da0f1-a0d8-45f0-901f-0922306ca932', 'GPU-AMD-9070XT', 'AMD Radeon RX 9070 XT',
    'Flagship AMD graphics card.',
    'AMD', 'Graphics Card', 1399.99, 8, 1.75,
    '/images/products/rx9070xt.jpg', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- Motherboards
('6fb7316b-795a-462f-a90c-db9c97595da6', 'MB-ASUS-X870E', 'ASUS ROG Strix X870E-E Gaming WiFi',
    'Premium AM5 motherboard.',
    'ASUS', 'Motherboard', 699.99, 12, 1.20,
    '/images/products/asus-x870e.jpg', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

('3c6a4279-d0b9-4502-8d5a-e95cdedece72', 'MB-MSI-Z890', 'MSI MAG Z890 Tomahawk WiFi',
    'Intel Z890 ATX motherboard.',
    'MSI', 'Motherboard', 529.99, 9, 1.25,
    '/images/products/msi-z890.jpg', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- Memory
('fb695ef4-118c-4022-a1cb-ca0a2e06e644', 'RAM-COR-32', 'Corsair Vengeance DDR5 32GB',
    '32GB (2x16GB) DDR5-6000 CL30.',
    'Corsair', 'Memory', 269.99, 25, 0.15,
    '/images/products/corsair-ddr5.jpg', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

('b2eba103-6a75-49d5-9283-e5dd6206d01c', 'RAM-GSK-64', 'G.Skill Trident Z5 RGB 64GB',
    '64GB DDR5-6400 memory kit.',
    'G.Skill', 'Memory', 489.99, 14, 0.18,
    '/images/products/gskill-z5.jpg', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- Storage
('316a544d-b492-480f-a2d5-6ed819784a7d', 'SSD-SAM-990-2TB', 'Samsung 990 Pro 2TB',
    'PCIe Gen4 NVMe SSD.',
    'Samsung', 'Storage', 319.99, 30, 0.05,
    '/images/products/samsung-990pro.jpg', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

('e9e0e950-5b30-4806-8475-85da7f3f18dc', 'SSD-WD-4TB', 'WD Black SN850X 4TB',
    'High-speed PCIe Gen4 SSD.',
    'Western Digital', 'Storage', 599.99, 11, 0.05,
    '/images/products/sn850x.jpg', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- Power Supplies
('6ab0ce4e-025b-4d55-8a8b-70127f792ec1', 'PSU-COR-850', 'Corsair RM850x',
    '850W 80+ Gold modular power supply.',
    'Corsair', 'Power Supply', 249.99, 18, 2.00,
    '/images/products/rm850x.jpg', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

('3614b9d9-43e6-454d-8749-8815c6a06ea9', 'PSU-SEA-1000', 'Seasonic Vertex GX-1000',
    '1000W fully modular PSU.',
    'Seasonic', 'Power Supply', 369.99, 8, 2.20,
    '/images/products/vertex1000.jpg', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- Cases
('91c40437-3da0-45e3-adf0-91eab1ab20fa', 'CASE-FRA-N7', 'Fractal Design North',
    'Mid-tower case with walnut front.',
    'Fractal Design', 'Case', 299.99, 13, 8.50,
    '/images/products/fractal-north.jpg', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

('d6f47cdb-eaa0-4f73-a8b9-6f7ec5eab2ec', 'CASE-LIA-O11', 'Lian Li O11 Dynamic EVO',
    'Popular dual-chamber PC case.',
    'Lian Li', 'Case', 329.99, 9, 9.20,
    '/images/products/o11-evo.jpg', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- Cooling
('ede7a4e6-e6b7-4c57-810c-20036eebcb7b', 'COOL-NOC-D15', 'Noctua NH-D15 G2',
    'Premium dual-tower CPU air cooler.',
    'Noctua', 'Cooling', 249.99, 16, 1.40,
    '/images/products/nhd15g2.jpg', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

('b10cd34f-5457-4f5a-94d5-3edae9d523cc', 'COOL-ARC-LIQ360', 'Arctic Liquid Freezer III 360',
    '360mm AIO liquid CPU cooler.',
    'Arctic', 'Cooling', 289.99, 7, 2.10,
    '/images/products/liquidfreezer3.jpg', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- Monitors
('fa1ded02-0f5e-4bed-836d-287a4e530166', 'MON-LG-32OLED', 'LG UltraGear 32" OLED',
    '32-inch 4K OLED gaming monitor.',
    'LG', 'Monitor', 1899.99, 5, 7.10,
    '/images/products/lg-oled32.jpg', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

('768ed27e-2ad8-4b7e-be28-99b10ab3565d', 'MON-DEL-27QHD', 'Dell UltraSharp 27"',
    '27-inch QHD productivity monitor.',
    'Dell', 'Monitor', 649.99, 10, 5.80,
    '/images/products/dell-ultrasharp27.jpg', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- Peripherals
('0b7323b3-4889-480c-b417-fd24788687ad', 'KEY-LOG-MX', 'Logitech MX Mechanical',
    'Wireless mechanical keyboard.',
    'Logitech', 'Keyboard', 299.99, 20, 0.90,
    '/images/products/mx-mechanical.jpg', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

('f6fa6789-0ddd-4e3d-b6f9-241465218080', 'MOU-LOG-GPX2', 'Logitech G Pro X Superlight 2',
    'Ultra-light wireless gaming mouse.',
    'Logitech', 'Mouse', 279.99, 24, 0.06,
    '/images/products/gprox2.jpg', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);