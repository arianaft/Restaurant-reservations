# Restaurant Reservations API

API REST para la gestión de reservas de un restaurante, desarrollada con Java y Spring Boot.

## Descripción

Sistema backend que permite gestionar las mesas de un restaurante y las reservas de los clientes. Incluye control de disponibilidad en tiempo real: una mesa puede estar libre, ocupada o reservada.

## Tecnologías

- Java 21
- Spring Boot 3.5
- Spring Data JPA / Hibernate
- H2 Database (desarrollo) → MySQL (producción)
- Maven
- Lombok

## Estructura del proyecto

```
src/main/java/com/ariana/restaurant_reservations/
├── model/
│   ├── RestaurantTable.java    # Entidad mesa
│   ├── TableStatus.java        # Enum: FREE, BUSY, RESERVED
│   ├── Customer.java           # Entidad cliente
│   ├── Reservation.java        # Entidad reserva
│   └── ReservationStatus.java  # Enum: PENDING, CONFIRMED, CANCELLED
├── repository/
│   ├── RestaurantTableRepository.java
│   ├── CustomerRepository.java
│   └── ReservationRepository.java
├── service/
│   ├── RestaurantTableService.java
│   ├── CustomerService.java
│   └── ReservationService.java
└── controller/
    ├── RestaurantTableController.java
    ├── CustomerController.java
    └── ReservationController.java
```

## Endpoints

### Mesas `/api/tables`
| Método | Endpoint | Descripción |
|--------|----------|-------------|
| GET | `/api/tables` | Obtener todas las mesas |
| GET | `/api/tables/{id}` | Obtener mesa por id |
| POST | `/api/tables` | Crear nueva mesa |
| DELETE | `/api/tables/{id}` | Eliminar mesa |

### Clientes `/api/customers`
| Método | Endpoint | Descripción |
|--------|----------|-------------|
| GET | `/api/customers` | Obtener todos los clientes |
| POST | `/api/customers` | Registrar cliente |

### Reservas `/api/reservations`
| Método | Endpoint | Descripción |
|--------|----------|-------------|
| GET | `/api/reservations` | Obtener todas las reservas |
| POST | `/api/reservations` | Crear reserva |
| PUT | `/api/reservations/{id}/cancel` | Cancelar reserva |

## Lógica de negocio

Al crear una reserva el sistema comprueba automáticamente:
- Que la mesa existe
- Que tiene capacidad suficiente para los comensales
- Que está disponible en la fecha y hora solicitadas

## Cómo ejecutar en local

1. Clona el repositorio
```bash
git clone https://github.com/arianaft/restaurant-reservations.git
```

2. Ejecuta la aplicación
```bash
./mvnw spring-boot:run
```

3. Accede a la consola H2 para ver la base de datos
```
http://localhost:8080/h2-console
JDBC URL: jdbc:h2:mem:reservasdb
Usuario: sa
Contraseña: (vacía)
```

## Estado del proyecto

- [x] Entidad RestaurantTable
- [x] Repository y Service de mesas
- [x] Controller de mesas
- [x] Entidad Customer y Reservation
- [x] Lógica de disponibilidad
- [ ] Migración a MySQL
- [ ] Despliegue en Railway
