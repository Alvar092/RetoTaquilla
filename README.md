# RetoTaquilla

La clase necesita controlar el material prestado durante una sesión. El catálogo inicial tiene:

| Material   | Unidades |
|------------|:--------:|
| Cable HDMI | 2        |
| Ratón      | 3        |
| Adaptador  | 1        |

Los datos se mantienen **en memoria**.

## Requisitos

### Menú

Un menú repetitivo permite:

1. Consultar disponibilidad por tipo
2. Prestar
3. Devolver
4. Salir

La persona elige el material y las unidades por teclado. Mostrad un mensaje claro tras cada operación.

### Validaciones

Rechazad:

- Cantidades no positivas.
- Opciones fuera de rango.
- Préstamos que superen el stock.
- Devoluciones mayores que los préstamos pendientes.

Una operación rechazada **conserva los datos**.

### Salida

Al salir, mostrad los préstamos pendientes por material y su total.
