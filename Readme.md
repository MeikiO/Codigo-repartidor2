
# Codigo-repartidor2

This is the first version of a personal proyect with the objetive of learn diferent tools, languages and frameworks. 

See also the next version [repartidores3](https://github.com/MeikiO/Codigo-repartidor3) in wich the app continues but in web aplication.


### Proyect Description
Repartidores 2 is a app to deliver newspaper in a small locality. The elements used for this proyect are the folowing ones:
 
- The app is done entirely in java.
- The persistence is done in Mysql.
- The interface is made with Java Swing
- The coordinates of client adresses are obtained from the positionStack API to
- To load the maps JXMaps is used.

The code of the maps is from [jxmapviewer2](https://github.com/msteiger/jxmapviewer2) repository. And the autor is [Martin Steiger](https://github.com/msteiger).


### Contents
The diferent folders that are in the repository are the tests and small examples done apart, to be used to build the [main proyect](https://github.com/MeikiO/Codigo-repartidor2/tree/main/zzz-Proyecto_repartidor_ElBueno) correctly.

| Project                 |   Description                                                |
|-------------------------|-------------------------------------------------------------|
| [01-Pruebas tablas con Radio Button](https://github.com/MeikiO/Codigo-repartidor2/tree/Migracion/01-Pruebas%20tablas%20con%20Radio%20Button) |This proyect is used to do a tabla in java swing with radio buttons and the necesary controllers and code to be easy to implement afterwards.  |
| [02-Prueba_mapa](https://github.com/MeikiO/Codigo-repartidor2/tree/Migracion/02-Prueba_mapa) | the code of jxmapviewer2 and the modifications done to be easy to implent in the main proyect.  |
| [03-Coordenadas_direccion](https://github.com/MeikiO/Codigo-repartidor2/tree/Migracion/03-Coordenadas_direccion) | Code to make the call to positionstack API  |
| [04-PresidentesGSON](https://github.com/MeikiO/Codigo-repartidor2/tree/Migracion/04-PresidentesGSON) | Code to parse the entire response received from positionstack web API  |
| [Mysql](https://github.com/MeikiO/Codigo-repartidor2/tree/Migracion/Mysql) | Folder with all the mysql code to make the app work  |