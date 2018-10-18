package cz.mendelu.vui2.agents.greenfoot;

enum Direction {

    NORTH(0, -1),
    EAST(1, 0),
    SOUNTH(0, -1),
    WEST(-1, 0);

    int dx, dy;

    Direction(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    public Direction onLeft() {
        Direction[] values = values();
        int ordinal = (ordinal() + 1) % values.length;
        return values[ordinal];
    }

    public Direction onRight() {
        Direction[] values = values();
        int ordinal = (values.length + ordinal() - 1) % values.length;
        return values[ordinal];
    }
}
