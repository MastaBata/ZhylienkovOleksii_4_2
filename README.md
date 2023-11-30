# Zhylienkov Oleksii
# Decoder

Цей проект представляє собою декодер повідомлень, закодованих двома різними методами.

## Опис

Даний проект реалізує два методи декодування закодованих повідомлень:
- **Заміна голосних**: усі голосні (a, e, i, o, u) замінюються на числа: a=1, e=2, i=3, o=4, u=5.
- **Заміна приголосних**: всі приголосні замінюються на наступний приголосний в послідовності.


## Приклад використання

```java
public class Main {
    public static void main(String[] args) {
        String encryptedMessage1 = "h3ll4, w5rld!";
        String encryptedMessage2 = "vetviph";

        String decryptedMessage1 = Decoder.decodeMessage(encryptedMessage1);
        String decryptedMessage2 = Decoder.decodeMessage(encryptedMessage2);

        System.out.println("Decrypted Message 1: " + decryptedMessage1);
        System.out.println("Decrypted Message 2: " + decryptedMessage2);
    }
}
