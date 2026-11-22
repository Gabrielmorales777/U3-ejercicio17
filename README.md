# U3-ejercicio17
# 🎁 Gestión de Membresías y Puntos de Fidelidad

Ejercicio de **Programación Orientada a Objetos en Java** que modela la cuenta de un programa de beneficios aplicando el principio de **encapsulamiento**. El saldo de puntos y el nivel de membresía son privados: los puntos se calculan internamente según reglas de negocio, y solo pueden gastarse mediante un método de canje que verifica que el saldo sea suficiente.

## 🎯 Objetivo

Administrar los puntos de fidelidad de un cliente ocultando su saldo y controlando tanto la acumulación como el canje, de modo que las reglas de negocio vivan dentro de la propia cuenta.

## ✨ Características

- Atributos privados: `numeroSocio`, `nivelMembresia` y `puntos` (más un acumulado histórico interno).
- `acumularPuntos(double montoCompra)`: calcula internamente los puntos según el monto y el nivel de la cuenta.
- `canjearPremio(int puntosRequeridos)`: descuenta puntos solo si el saldo oculto es suficiente.
- Niveles BRONCE, PLATA y ORO con multiplicadores crecientes, que se actualizan automáticamente según los puntos acumulados históricamente.
- Rechazo de montos negativos, cero y valores no numéricos (`NaN`).
- Sin setters de puntos ni de nivel: el estado solo cambia mediante las operaciones controladas.


## 📚 Conceptos aplicados

Encapsulamiento · Reglas de negocio · Modificadores de acceso · Validación de datos · Constructores · Métodos privados


![U3 ejercicio17](U3%20ejercicio17.png)
