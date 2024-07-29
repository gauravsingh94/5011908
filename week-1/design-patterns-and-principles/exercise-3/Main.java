public class Main {
    public static void main(String[] args) {
        Computer computer1 = new Computer.Builder().setCpu("Apple M3 Pro").setRam(16).setStorage(512).setHasGraphicsCard(true).setHasSoundCard(true).build();
        computer1.getSpec();
    }
}

class Computer {
    private String cpu;
    private int ram;
    private int storage;
    private boolean hasGraphicsCard;
    private boolean hasSoundCard;

    Computer(Builder builder) {
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.storage = builder.storage;
        this.hasGraphicsCard = builder.hasGraphicsCard;
        this.hasSoundCard = builder.hasSoundCard;
    }

    public static class Builder {
        private String cpu;
        private int ram;
        private int storage;
        private boolean hasGraphicsCard;
        private boolean hasSoundCard;

        public Builder setCpu(String cpu) {
            this.cpu = cpu;
            return this;
        }

        public Builder setRam(int ram) {
            this.ram = ram;
            return this;
        }

        public Builder setStorage(int storage) {
            this.storage = storage;
            return this;
        }

        public Builder setHasGraphicsCard(boolean hasGraphicsCard) {
            this.hasGraphicsCard = hasGraphicsCard;
            return this;
        }

        public Builder setHasSoundCard(boolean hasSoundCard) {
            this.hasSoundCard = hasSoundCard;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }

    }

    void getSpec() {
        System.out.println("Cpu: " + this.cpu);
        System.out.println("Ram: " + this.ram);
        System.out.println("Storage: " + this.storage);
        System.out.println("Graphics Card: " + this.hasGraphicsCard);
        System.out.println("Sound Card: " + this.hasSoundCard);
    }
}

