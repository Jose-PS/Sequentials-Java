SELECT
    "A1"."NOMBRE"  "NOMBRE",
    "A1"."SALARIO" "SALARIO"
FROM
    "C##DPTO"."EMPLEADO" "A1"
WHERE
    "A1"."SALARIO" > 1000;

SELECT
    "A1"."NOMBRE" "NOMBRE"
FROM
    "C##DPTO"."EMPLEADO" "A1"
WHERE
    "A1"."COMISION" / "A1"."SALARIO" > 20;
    
SELECT
    "A1"."CODEMPLE"                               "CODEMPLE",
    "A1"."CODDPTO"                                "CODDPTO",
    "A1"."NOMBRE"                                 "NOMBRE",
    ( "A1"."SALARIO" + "A1"."COMISION" ) * 166.38 "SALARIOTOTAL"
FROM
    "C##DPTO"."EMPLEADO" "A1"
WHERE
    "A1"."SALARIO" + "A1"."COMISION" > 1800
ORDER BY
    "A1"."CODDPTO",
    "A1"."NOMBRE";                                
    