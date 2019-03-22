class Solution {
    
    enum Direction{
        RIGHT(1),
        LEFT(-1);

        private int value;

        Direction(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
    
    class Data {
        char[] name;
        int index;
        int count;

        Data(char[] name) {
            this.name = name;
        }

        void move(Direction direction) {
            this.index += direction.getValue();
            this.count += 1;

            if (this.index < 0) {
                this.index = name.length - 1;
            }

            if (this.index >= name.length) {
                this.index = 0;
            }
        }

        void findAlphabetCount() {
            char c = this.name[this.index];

            this.count += Math.min(Math.abs(A - c), Math.abs(Z - c) + 1);
            this.name[this.index] = 'A';
        }
    }
    
    private final char A = 'A';
    private final char Z = 'Z'; 
    
    public int solution(String name) {
        Data data = new Data(name.toCharArray());
        computeData(data);

        return data.count;
    }
    
    private Data computeData(Data data) {
        if (isFinish(data.name)) {
            return data;
        }

        data.findAlphabetCount();

        int rightNumberOfConsecutiveKey = findConsecutiveKeyCount(Direction.RIGHT, data);
        int leftNumberOfConsecutiveKey = findConsecutiveKeyCount(Direction.LEFT, data);

        int rightNextNumberOfFindKey = findNextKeyCount(Direction.RIGHT, data);
        int leftNextNumberOfFindKey = findNextKeyCount(Direction.LEFT, data);

        if (leftNumberOfConsecutiveKey == 0 && rightNumberOfConsecutiveKey == 0) {
            if (leftNextNumberOfFindKey == 0 && rightNextNumberOfFindKey == 0) {
                return data;
            } else if (leftNextNumberOfFindKey < rightNextNumberOfFindKey) {
                data.move(Direction.LEFT);
            } else {
                data.move(Direction.RIGHT);
            }
        } else if (leftNumberOfConsecutiveKey == 0) {
            data.move(Direction.RIGHT);
        } else if (rightNumberOfConsecutiveKey == 0) {
            data.move(Direction.LEFT);
        } else if (leftNumberOfConsecutiveKey < rightNumberOfConsecutiveKey) {
            data.move(Direction.LEFT);
        } else {
            data.move(Direction.RIGHT);
        }

        return computeData(data);
    }

    private int findNextKeyCount(Direction direction, Data data) {
        int count = 0;
        if (direction.equals(Direction.RIGHT)) {
            for (int i = data.index + 1; i < data.index + data.name.length; i++) {
                if (data.name[i % data.name.length] == 'A') {
                    count++;
                } else {
                    return count++;
                }

            }
        } else if (direction.equals(Direction.LEFT)) {
            for (int i = data.index + data.name.length; i > data.index; i--) {
                if (data.name[i % data.name.length] == 'A') {
                    count++;
                } else {
                    return count++;
                }
            }
        }
        return 0;
    }

    private int findConsecutiveKeyCount(Direction direction, Data data) {
       int count = 0;
        if (direction.equals(Direction.RIGHT)) {
            for (int i = data.index + 1; i < data.index + data.name.length; i++) {
                if (data.name[i % data.name.length] != 'A') {
                    count++;
                } else {
                    break;
                }
            }
        } else if (direction.equals(Direction.LEFT)) {
            for (int i = data.index + data.name.length - 1; i > data.index; i--) {
                if (data.name[i % data.name.length] != 'A') {
                    count++;
                } else {
                    break;
                }
            }
        }
        return count;
    }

    private boolean isFinish(char[] name) {
        for (char c : name) {
            if (c != 'A') {
                return false;
            }
        }
        return true;
    }
}