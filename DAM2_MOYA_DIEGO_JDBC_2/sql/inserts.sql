--CentroForense
INSERT INTO CENTROS_FORENSES VALUES (1, 'Centro Nacional de Zaragoza', 'ESPAÑA',    5, 'DIEGO_MOYA_DAM2');
INSERT INTO CENTROS_FORENSES VALUES (2, 'Laboratorio Federal de Florida',    'EEUU',      4, 'DIEGO_MOYA_DAM2');
INSERT INTO CENTROS_FORENSES VALUES (3, 'Instituto Forense de Valencia', 'ESPAÑA',    3, 'DIEGO_MOYA_DAM2');
INSERT INTO CENTROS_FORENSES VALUES (4, 'Centre de Sciences Paris',     'FRANCIA',   4, 'DIEGO_MOYA_DAM2');
INSERT INTO CENTROS_FORENSES VALUES (5, 'Forensic Science McGregor',           'IRLANDA',   2, 'DIEGO_MOYA_DAM2');

--MuestraForense
INSERT INTO MUESTRAS_FORENSES VALUES (1, 'CASO-2026-001', 'ADN',        '2026-01-10', 'EN_CUSTODIA',  1, 'DIEGO_MOYA_DAM2');
INSERT INTO MUESTRAS_FORENSES VALUES (2, 'CASO-2026-002', 'HUELLA',     '2026-01-15', 'PROCESADA',    1, 'DIEGO_MOYA_DAM2');
INSERT INTO MUESTRAS_FORENSES VALUES (3, 'CASO-2026-003', 'SANGRE',     '2026-02-03', 'EN_CUSTODIA',  2, 'DIEGO_MOYA_DAM2');
INSERT INTO MUESTRAS_FORENSES VALUES (4, 'CASO-2026-004', 'ADN',        '2026-02-20', 'ANALIZADA',    3, 'DIEGO_MOYA_DAM2');
INSERT INTO MUESTRAS_FORENSES VALUES (5, 'CASO-2026-005', 'FIBRA',      '2026-03-05', 'PENDIENTE',    4, 'DIEGO_MOYA_DAM2');
INSERT INTO MUESTRAS_FORENSES VALUES (6, 'CASO-2026-006', 'ADN',        '2026-03-18', 'EN_CUSTODIA',  1, 'DIEGO_MOYA_DAM2');
INSERT INTO MUESTRAS_FORENSES VALUES (7, 'CASO-2026-007', 'TOXICOLOGIA','2026-04-01', 'PROCESADA',    5, 'DIEGO_MOYA_DAM2');

--InformeForense
INSERT INTO INFORMES_FORENSES VALUES (1, TRUE,  95, 'ADN positivo con coincidencia en base de datos nacional. Sujeto identificado.',       1, 'DIEGO_MOYA_DAM2');
INSERT INTO INFORMES_FORENSES VALUES (2, FALSE, 10, 'Huella dactilar no coincide con ningún registro. Caso archivado temporalmente.',      2, 'DIEGO_MOYA_DAM2');
INSERT INTO INFORMES_FORENSES VALUES (3, FALSE, 30, 'Muestra de sangre no vinculada al sospechoso principal. Se amplía investigación.',    3, 'DIEGO_MOYA_DAM2');
INSERT INTO INFORMES_FORENSES VALUES (4, TRUE,  92, 'ADN positivo con coincidencia en base de datos nacional. Sujeto identificado.',      4, 'DIEGO_MOYA_DAM2');
INSERT INTO INFORMES_FORENSES VALUES (5, FALSE, 20, 'Fibra textil analizada. No se establece relación directa con el delito.',             5, 'DIEGO_MOYA_DAM2');
INSERT INTO INFORMES_FORENSES VALUES (6, TRUE,  98, 'ADN positivo con coincidencia en base de datos nacional. Sujeto identificado.',     6, 'DIEGO_MOYA_DAM2');
INSERT INTO INFORMES_FORENSES VALUES (7, FALSE, 45, 'Análisis toxicológico con presencia de sustancias controladas. Riesgo moderado.',    7, 'DIEGO_MOYA_DAM2');
