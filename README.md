## Configure Hibernate

Before running the Employee Management System, open `hibernate.cfg.xml` and update **only the following four properties** with your local MySQL database details:

```xml
<property name="hibernate.connection.url">jdbc:mariadb://localhost:3306/mydb</property>
<property name="hibernate.connection.username">swap</property>
<property name="hibernate.connection.password">12345678</property>
<property name="hibernate.connection.driver_class">org.mariadb.jdbc.Driver</property>
```

- **URL:** Replace `mariadb` with your database vendor name that is `mysql`.
- **URL:** Replace `mydb` with your database name.
- **Username:** Replace `swap` with your MySQL username.
- **Password:** Replace `12345678` with your MySQL password.
- **Driver class:** Change it to MySQL Driver Class.

**Note:** If Required Do modify any other properties in `hibernate.cfg.xml`.
