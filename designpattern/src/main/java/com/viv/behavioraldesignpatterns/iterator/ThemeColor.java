package com.viv.behavioraldesignpatterns.iterator;

//This enum represents the agrregate from iterator pattern
public enum ThemeColor {
    RED, GREEN, BLUE, YELLOW, ORANGE, BLACK, WHITE, PURPLE, PINK, BROWN;

    public static Iterator<ThemeColor> getIterator() {
        return new ThemeColorIterator();
    }

    private static class ThemeColorIterator implements Iterator<ThemeColor> {
        private int position;

        @Override
        public boolean hasNext() {
            return position < ThemeColor.values().length;
        }

        @Override
        public ThemeColor next() {
            return ThemeColor.values()[position++];
        }
    }
}
