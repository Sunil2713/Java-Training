# OneWeb

Maven WAR project demonstrating a basic JSP/Servlet user-management application with a MySQL-backed DAO/service layer.

## Import into Eclipse

1. `File` -> `Import` -> `Maven` -> `Existing Maven Projects`.
2. Select the `oneweb` folder.
3. Run `Maven` -> `Update Project`.
4. Deploy to a Servlet 4 compatible server such as Tomcat 9.

## Local database configuration

Copy `src/main/resources/db.properties.example` to `src/main/resources/db.properties` and set the local MySQL password. The real `db.properties` is intentionally ignored by Git.
