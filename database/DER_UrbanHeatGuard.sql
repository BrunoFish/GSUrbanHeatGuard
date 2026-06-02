-- 1. Criação da Tabela de Regiões (Entidade Principal)
CREATE TABLE TB_REGIAO_URBANA (
    id_regiao INT PRIMARY KEY,
    nome_local VARCHAR(100) NOT NULL,
    latitude DECIMAL(10, 8) NOT NULL,
    longitude DECIMAL(11, 8) NOT NULL,
    raio_metros INT NOT NULL
);

-- 2. Criação da Tabela de Sensores (Entidade Intermediária)
CREATE TABLE TB_SENSOR (
    id_sensor INT PRIMARY KEY,
    id_regiao INT NOT NULL,
    tipo_sensor VARCHAR(50) NOT NULL,
    data_ativacao DATE NOT NULL,
    CONSTRAINT fk_regiao_sensor FOREIGN KEY (id_regiao) 
        REFERENCES TB_REGIAO_URBANA(id_regiao)
);

-- 3. Criação da Tabela de Alertas Térmicos (Entidade de Evento)
CREATE TABLE TB_ALERTA_TERMICO (
    id_alerta INT PRIMARY KEY,
    id_sensor INT NOT NULL,
    temperatura_registrada DECIMAL(5, 2) NOT NULL,
    nivel_severidade VARCHAR(20) NOT NULL,
    data_alerta DATE NOT NULL,
    CONSTRAINT fk_sensor_alerta FOREIGN KEY (id_sensor) 
        REFERENCES TB_SENSOR(id_sensor)
);