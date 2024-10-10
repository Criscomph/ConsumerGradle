BEGIN
   EXECUTE IMMEDIATE '
   CREATE TABLE paciente (
       codigo NUMBER PRIMARY KEY,
       nome VARCHAR2(100) NOT NULL,
       cpf VARCHAR2(11) UNIQUE NOT NULL,
       data_nascimento DATE NOT NULL
   )';
EXCEPTION
   WHEN OTHERS THEN
      IF SQLCODE != -955 THEN
         RAISE;
      END IF;
END;
/
