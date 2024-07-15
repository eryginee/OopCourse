package eryginee.range;

public class Range {
    private double from;
    private double to;

    public Range(double from, double to) {
        this.from = from;
        this.to = to;
    }

    public double getFrom() {
        return from;
    }

    public void setFrom(double from) {
        this.from = from;
    }

    public double getTo() {
        return to;
    }

    public void setTo(double to) {
        this.to = to;
    }

    public double getLength() {
        return to - from;
    }

    public boolean isInside(double enteredNumber) {
        return enteredNumber >= from && enteredNumber <= to;
    }

    public Range getIntersection(Range secondRange) {
        double newFrom = Math.max(this.from, secondRange.getFrom());
        double newTo = Math.min(this.to, secondRange.getTo());

        if (newFrom < newTo) { // Если новое начало диапазона меньше нового конца, значит пересечение существует
            return new Range(newFrom, newTo);
        } else {
            return null;
        }
    }

    public Range[] getUnion(Range secondRange) {
        double firstFrom = this.from;
        double firstTo = this.to;
        double secondFrom = secondRange.getFrom();
        double secondTo = secondRange.getTo();

        Range[] result;
        if (firstTo < secondFrom || secondTo < firstFrom) {
            // Нет пересечения, добавляем оба интервала в результат
            result = new Range[]{this, secondRange};
        } else {
            // Если есть пересечение, объединяем интервалы
            double newFrom = Math.min(firstFrom, secondFrom);
            double newTo = Math.max(firstTo, secondTo);

            result = new Range[]{new Range(newFrom, newTo)};
        }

        return result;
    }

    public Range[] getDifference(Range secondRange) {
        double firstFrom = this.from;
        double firstTo = this.to;
        double secondFrom = secondRange.getFrom();
        double secondTo = secondRange.getTo();

        Range[] result;

        if (firstTo <= secondFrom || secondTo <= firstFrom) {
            // Интервалы не пересекаются, возвращаем исходный интервал this
            result = new Range[]{this};
        } else if (firstFrom < secondFrom && firstTo > secondTo) {
            // Второй интервал полностью внутри первого, разделяем исходный интервал на два
            result = new Range[]{new Range(firstFrom, secondFrom), new Range(secondTo, firstTo)};
        } else if (firstFrom < secondFrom) {
            // Часть первого интервала слева от второго
            result = new Range[]{new Range(firstFrom, secondFrom)};
        } else {
            // Часть первого интервала справа от второго
            result = new Range[]{new Range(secondTo, firstTo)};
        }

        return result;
    }

    public String toString() {
        return "[" + from + ", " + to + "]";
    }
}
