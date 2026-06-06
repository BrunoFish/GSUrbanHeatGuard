-- 1. Criação da Tabela de Regiões (Entidade Principal)
CREATE TABLE TB_REGIAO_URBANA (
    id_regiao INT PRIMARY KEY,
    nome_local VARCHAR(100) NOT NULL,
    raio_metros INT NOT NULL,
    data_implantacao DATE NOT NULL
);

-- 2. Criação da Tabela de Pontos do Polígono (Entidade Filha)
CREATE TABLE TB_PONTO_POLIGONO (
    id_ponto INT PRIMARY KEY,
    id_regiao INT NOT NULL,
    ordem_ponto INT NOT NULL,
    latitude DECIMAL(10, 8) NOT NULL,
    longitude DECIMAL(11, 8) NOT NULL,
    CONSTRAINT fk_regiao_ponto FOREIGN KEY (id_regiao) 
        REFERENCES TB_REGIAO_URBANA(id_regiao)
);

-- 3. Criação da Tabela de Equipamentos (Entidade Intermediária)
CREATE TABLE TB_EQUIPAMENTO (
    id_equipamento INT PRIMARY KEY,
    id_regiao INT NOT NULL,
    tipo_equipamento VARCHAR(50) NOT NULL,
    status_operacao VARCHAR(20) NOT NULL,
    CONSTRAINT fk_regiao_equipamento FOREIGN KEY (id_regiao) 
        REFERENCES TB_REGIAO_URBANA(id_regiao)
);

-- 4. Criação da Tabela de Leituras Térmicas (Entidade de Evento/Histórico)
CREATE TABLE TB_LEITURA_TERMICA (
    id_leitura INT PRIMARY KEY,
    id_equipamento INT NOT NULL,
    temperatura_registrada DECIMAL(5, 2) NOT NULL,
    status_termico VARCHAR(20) NOT NULL,
    data_hora_leitura TIMESTAMP NOT NULL,
    CONSTRAINT fk_equipamento_leitura FOREIGN KEY (id_equipamento) 
        REFERENCES TB_EQUIPAMENTO(id_equipamento)
);