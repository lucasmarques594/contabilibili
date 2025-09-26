CREATE TABLE cartorio (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL
);

CREATE TABLE pessoa (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    tipo_pessoa VARCHAR(50) NOT NULL
);

CREATE TABLE processo (
    id BIGSERIAL PRIMARY KEY,
    numero VARCHAR(255) NOT NULL,
    cartorio_id BIGINT,
    interessado_id BIGINT,
    CONSTRAINT fk_processo_cartorio FOREIGN KEY (cartorio_id) REFERENCES cartorio(id),
    CONSTRAINT fk_processo_interessado FOREIGN KEY (interessado_id) REFERENCES pessoa(id)
);

CREATE TABLE lancamento_financeiro (
    id BIGSERIAL PRIMARY KEY,
    descricao VARCHAR(255) NOT NULL,
    valor DECIMAL(19, 2) NOT NULL,
    data_lancamento DATE NOT NULL,
    tipo_lancamento VARCHAR(50) NOT NULL,
    processo_id BIGINT,
    CONSTRAINT fk_lancamento_processo FOREIGN KEY (processo_id) REFERENCES processo(id)
);