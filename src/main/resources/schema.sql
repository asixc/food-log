CREATE TABLE IF NOT EXISTS meal_log (
                          id SERIAL PRIMARY KEY,                           -- Identificador único autogenerado
                          email VARCHAR(255)  NOT NULL, -- Correo electrónico del usuario que registró la comida
                          meal_type VARCHAR(20) NOT NULL, -- Tipo de comida (desayuno, almuerzo, merienda, cena)
                          date DATE NOT NULL, -- Fecha en que se consumió la comida
                          time TIME NOT NULL, -- Hora exacta de la comida
                          food_items TEXT NOT NULL, -- Lista de alimentos consumidos (ej. "pollo, arroz, ensalada")
                          calories DECIMAL(6,2) DEFAULT NULL, -- Estimación de calorías consumidas (opcional)
                          photo_url TEXT DEFAULT NULL, -- URL de la foto de la comida (opcional)
                          notes TEXT DEFAULT NULL, -- Notas adicionales sobre la comida
                          location VARCHAR(255) DEFAULT NULL, -- Ubicación donde se consumió la comida (opcional)
                          mood VARCHAR(50) DEFAULT NULL, -- Estado de ánimo al comer (ej. satisfecho, con hambre, delicioso)
                          diet_type VARCHAR(50) DEFAULT NULL, -- Tipo de dieta (ej. keto, vegano, alto en proteínas)
                          diners INT DEFAULT 1, -- Número de comensales en la comida
                          companions TEXT DEFAULT NULL, -- Nombres de las personas con quienes se compartió la comida
                          created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP -- Fecha y hora de creación del registro
);

-- Índices para optimización
CREATE INDEX IF NOT EXISTS idx_meal_log_email ON meal_log(email);
CREATE INDEX IF NOT EXISTS idx_meal_log_date ON meal_log(date);
CREATE INDEX IF NOT EXISTS idx_meal_log_meal_type ON meal_log(meal_type);
-- Índice para el estado de ánimo
CREATE INDEX IF NOT EXISTS idx_meal_log_mood ON meal_log(mood);

-- Comentarios en las columnas
COMMENT ON TABLE meal_log IS 'Tabla para registrar el historial de comidas de los usuarios';
COMMENT ON COLUMN meal_log.id IS 'Identificador único del registro';
COMMENT ON COLUMN meal_log.email IS 'Correo electrónico del usuario que registró la comida';
COMMENT ON COLUMN meal_log.meal_type IS 'Tipo de comida (desayuno, almuerzo, merienda, cena)';
COMMENT ON COLUMN meal_log.date IS 'Fecha en que se consumió la comida';
COMMENT ON COLUMN meal_log.time IS 'Hora exacta de la comida';
COMMENT ON COLUMN meal_log.food_items IS 'Lista de alimentos consumidos (ej. "pollo, arroz, ensalada")';
COMMENT ON COLUMN meal_log.calories IS 'Estimación de calorías consumidas (opcional)';
COMMENT ON COLUMN meal_log.photo_url IS 'URL de la foto de la comida (opcional)';
COMMENT ON COLUMN meal_log.notes IS 'Notas adicionales sobre la comida';
COMMENT ON COLUMN meal_log.location IS 'Ubicación donde se consumió la comida (opcional)';
COMMENT ON COLUMN meal_log.mood IS 'Estado de ánimo al comer (ej. satisfecho, con hambre, delicioso)';
COMMENT ON COLUMN meal_log.diet_type IS 'Tipo de dieta (ej. keto, vegano, alto en proteínas)';
COMMENT ON COLUMN meal_log.diners IS 'Número de comensales en la comida';
COMMENT ON COLUMN meal_log.companions IS 'Nombres de las personas con quienes se compartió la comida';
COMMENT ON COLUMN meal_log.created_at IS 'Fecha y hora de creación del registro';
