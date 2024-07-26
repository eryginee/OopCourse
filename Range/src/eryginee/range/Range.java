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

    public boolean isInside(double numberToCheck) {
        return numberToCheck >= from && numberToCheck <= to;
    }

    public Range getIntersection(Range range) {
        double resultFrom = Math.max(from, range.from);
        double resultTo = Math.min(to, range.to);

        if (resultFrom < resultTo) { // Если новое начало диапазона меньше нового конца, значит пересечение существует
            return new Range(resultFrom, resultTo);
        }

        return null;
    }

    public Range[] getUnion(Range range) {
        if (to < range.from || range.to < from) {
            // Нет пересечения, добавляем оба интервала в результат
            return new Range[]{new Range(from, to), new Range(range.from, range.to)};
        }

        // Если есть пересечение, объединяем интервалы
        double newFrom = Math.min(from, range.from);
        double newTo = Math.max(to, range.to);

        return new Range[]{new Range(newFrom, newTo)};
    }

    public Range[] getDifference(Range range) {
        if (to <= range.from || range.to <= from) {         // Интервалы не пересекаются, возвращаем исходный интервал
            return new Range[]{new Range(from, to)};
        }

        if (from < range.from && to > range.to) {           // Второй интервал строго внутри первого, разделяем исходный интервал на два
            return new Range[]{new Range(from, range.from), new Range(range.to, to)};
        }

        if (from < range.from && to <= range.to) {            // Часть первого интервала слева от второго, конец второго интервала >= концу первого
            return new Range[]{new Range(from, range.from)};
        }

        if (from >= range.from && to > range.to) {            // Часть первого интервала справа от второго
            return new Range[]{new Range(range.to, to)};
        }

        return new Range[0];            // В случае, если интервалы совпадают, либо первый интервал меньше второго и находится внутри него (одна из границ может совпадать)
    }

    @Override
    public String toString() {
        return "[" + from + ", " + to + "]";
    }
}
