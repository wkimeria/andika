package com.andika;
import static spark.Spark.*;

/**
 * Hello world!
 *
 */
public class MainApp
{
    public static void main( String[] args )
    {
        get("/hello", (req, res) -> "Is it me you're looking for.. and I wonder..");

        get("/goodbye", (req, res) -> "Hasta La Vista!");
    }
}
