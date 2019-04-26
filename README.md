## Simple Hotel Room Booking Application
#### How to run?

You will need `maven` and `jdk8` installed on the machine.

- Simply go to the project folder and run
 - `mvn clean;mvn package;mvn spring-boot:run`
 - By default it uses `8080` as port


- Besides the maven dependencies, you will need a `p12` file with your API credentials places to the `resources` folder to use `Google Calendar` integration. You may check [Google Developer Console](https://console.developers.google.com/) for the details about how to enable Google APIs and get your p12 file. Copy p12 file as `google.p12` into the resources folder.
- After the p12 file, open the [HotelappApplication.java](https://github.com/durmusdeniz/hotel_service/blob/master/src/main/java/la/demo/hotelapp/HotelappApplication.java) and put your email address linked with the Google Services, and your service account id. These are needed for auth purposes with Google Service.