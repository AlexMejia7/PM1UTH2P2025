package com.example.pm1uth2p2025.Configuracion;

public class Transacciones {

    // Nombre de la base de datos
    public static final String NameDB = "MOVIL1";

    // Nombre de la tabla
    public static final String tablaPersonas = "personas";

    // Campos de la tabla
    public static final String id = "id";
    public static final String nombres = "nombres";
    public static final String apellidos = "apellidos";
    public static final String correo = "correo";
    public static final String telefono = "telefono";

    // DDL - Create table

    public static final String CreateTablePersonas =
            "CREATE TABLE " + tablaPersonas + " (" +
                    id + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    nombres + " TEXT, " +
                    apellidos + " TEXT, " +
                    correo + " TEXT, " +
                    telefono + " TEXT)";

    // DDL - Drop table

    public static final String DROTablePersonas = "DROP TABLE IF EXISTS " + tablaPersonas;

    // DML - Select
    public static final String SelectPersonas =
            "SELECT * FROM " + tablaPersonas;
}