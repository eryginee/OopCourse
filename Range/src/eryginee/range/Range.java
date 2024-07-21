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
        double resultFrom = range.from;
        double resultTo = range.to;

        if (to < resultFrom || resultTo < from) {
            // Нет пересечения, добавляем оба интервала в результат
            return new Range[]{new Range(from, to), new Range(resultFrom, resultTo)};
        }

        // Если есть пересечение, объединяем интервалы
        double newFrom = Math.min(from, resultFrom);
        double newTo = Math.max(to, resultTo);

        return new Range[]{new Range(newFrom, newTo)};
    }

    public Range[] getDifference(Range range) {
        double resultFrom = range.from;
        double resultTo = range.to;

        if (to <= resultFrom || resultTo <= from) {         // Интервалы не пересекаются, возвращаем исходный интервал
            return new Range[]{new Range(from, to)};
        } else if (from < resultFrom && to > resultTo) {           // Второй интервал строго внутри первого, разделяем исходный интервал на два
            return new Range[]{new Range(from, resultFrom), new Range(resultTo, to)};
        } else if (from < resultFrom && to <= resultTo) {            // Часть первого интервала слева от второго, конец второго интервала >= концу первого
            return new Range[]{new Range(from, resultFrom)};
        } else if (from >= resultFrom && to > resultTo) {            // Часть первого интервала справа от второго
            return new Range[]{new Range(resultTo, to)};
        }

        return null;            // В случае, если интервалы совпадают, либо первый интервал меньше второго и находится внутри него (одна из границ может совпадать)
    }

    @Override
    public String toString() {
        return "[" + from + ", " + to + "]";
    }
}
