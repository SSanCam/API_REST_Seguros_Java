INSERT INTO seguros (id_seguro, nif, nombre, ape1, ape2, edad, num_hijos, fecha_creacion, sexo, casado, embarazada)
VALUES
    (1, "12345678A", "Juan", "Pérez", "García", 35, 2, "2024-11-01 10:00:00", "Hombre", TRUE, FALSE),
    (2, "87654321B", "María", "López", NULL, 28, 1, "2024-10-20 14:30:00", "Mujer", TRUE, TRUE);
INSERT INTO asistencias_medicas (id_asistencia_medica, id_seguro, breve_descripcion, lugar, explicacion, tipo_asistencia, fecha, hora, importe)
VALUES
    (1, 1, "Consulta médica general", "Madrid", "Consulta por síntomas leves", "Consulta", "2024-11-02", "09:30:00", 50.00),
    (2, 1, "Urgencia médica", "Barcelona", "Dolor abdominal intenso", "Urgencia", "2024-11-03", "12:15:00", 150.00),
    (3, 2, "Revisión ginecológica", "Sevilla", "Control durante embarazo", "Consulta", "2024-11-04", "10:00:00", 70.00);
