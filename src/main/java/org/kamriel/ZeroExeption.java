package org.kamriel;

public class ZeroExeption {
    public static class ZeroException extends ArithmeticException {
        public ZeroException(String massage) {
            super(massage);
        }
    }
}
