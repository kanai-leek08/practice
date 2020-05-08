    
    public enum Yen {
        YEN10(10), YEN50(50), YEN100(100), YEN500(500), YEN1000(1000);

        private int value;

        Yen(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
