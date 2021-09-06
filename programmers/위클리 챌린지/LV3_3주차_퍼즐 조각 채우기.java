import java.util.*;
import java.util.stream.Collectors;

class LV3_3주차_퍼즐 조각 채우기 {
    public int solution(int[][] game_board, int[][] table) {
        int answer = 0;

        List<Block> gameBlocks = getArrayOfBlocks(0, game_board);
        List<Block> tableBlocks = getArrayOfBlocks(1, table);

        for (Block b1 : tableBlocks) {
            for (Block b2 : gameBlocks) {
                if (b2.isSameShaped(b1)) {
                    answer += b1.coords.size();
                    gameBlocks.remove(b2);
                    break;
                }
            }
        }

        return answer;
    }

    private List<Block> getArrayOfBlocks(int target, int[][] board) {
        List<Block> blocks = new ArrayList<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (target == board[j][i]) {
                    blocks.add(getBlock(target, board, j, i));
                }
            }
        }

        return blocks;
    }

    private Block getBlock(int target, int[][] board, int x, int y) {
        int nonTarget = 0;
        if (target == 0) {
            nonTarget = 1;
        }
        Queue<Coord> queue = new LinkedList<>();
        List<Coord> coords = new ArrayList<>();
        // Set<Coord> coords = new HashSet<>();

        queue.add(new Coord(x, y));
        while(!queue.isEmpty()) {
            Coord coord = queue.poll();
            coords.add(coord);
            board[coord.x][coord.y] = nonTarget;
            if (coord.x + 1 < board.length && board[coord.x + 1][coord.y] == target) {
                Coord newCoord = new Coord(coord.x + 1, coord.y);
                if (!coords.contains(newCoord)) queue.add(newCoord);
            }
            if (coord.y + 1 < board.length && board[coord.x][coord.y + 1] == target) {
                Coord newCoord = new Coord(coord.x, coord.y + 1);
                if (!coords.contains(newCoord)) queue.add(newCoord);
            }
            if (coord.x - 1 >= 0 && board[coord.x - 1][coord.y] == target) {
                Coord newCoord = new Coord(coord.x - 1, coord.y);
                if (!coords.contains(newCoord)) queue.add(newCoord);
            }
            if (coord.y - 1 >= 0 && board[coord.x][coord.y - 1] == target) {
                Coord newCoord = new Coord(coord.x, coord.y - 1);
                if (!coords.contains(newCoord)) queue.add(newCoord);
            }
        }

        return Block.of(coords);
    }

}

class Coord {
    public final int x;
    public final int y;

    public Coord(int x, int y) {
        this.x = x;
        this.y = y;
    }

    static int getMaxX(Collection<Coord> coords) {
        return coords.stream().mapToInt(c -> c.x).max().getAsInt();
    }

    static int getMaxY(Collection<Coord> coords) {
        return coords.stream().mapToInt(c -> c.y).max().getAsInt();
    }

    static int getMinX(Collection<Coord> coords) {
        return coords.stream().mapToInt(c -> c.x).min().getAsInt();
    }

    static int getMinY(Collection<Coord> coords) {
        return coords.stream().mapToInt(c -> c.y).min().getAsInt();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coord coord = (Coord) o;
        return x == coord.x && y == coord.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override public String toString() {
        return "(" + this.x + ", " + this.y + ")";
    }
}

class Block {
    public final List<Coord> coords;

    private Block(List<Coord> coords) {
        this.coords = coords;
    }

    public static Block of(List<Coord> coords) {
        return new Block(shiftToZeroZero(coords));
    }

    public boolean isSameShaped(Block other) {
        if (equals(other)) return true;
        for (Block block = other.rotate(); !block.equals(other); block = block.rotate()) {
            if (equals(block)) return true;
        }

        return false;
    }

    private Block rotate() {
        List<Coord> rotated = coords.stream()
                .map(c -> new Coord(c.y, -c.x))
                .collect(Collectors.toList());
        return new Block(shiftToZeroZero(rotated));
    }

    private static List<Coord> shiftToZeroZero(List<Coord> coords) {
        int minX = Coord.getMinX(coords);
        int minY = Coord.getMinY(coords);
        return coords.stream()
                .distinct()
                .map(c -> new Coord(c.x - minX, c.y - minY))
                .collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Block block = (Block) o;
        // return Objects.equals(coords, block.coords);
        return new HashSet<Coord>(coords).equals(new HashSet<>(block.coords));
    }

    @Override
    public int hashCode() {
        return Objects.hash(coords);
    }
    
    @Override public String toString() {
		StringBuilder sb = new StringBuilder();
		int maxX = Coord.getMaxX(coords);
		int maxY = Coord.getMaxY(coords);
		for (int x = -1; x <= maxX + 1; x++) {
			for (int y = -1; y <= maxY + 1; y++) {
				Coord coord = new Coord(x, y);
				boolean isBlock = coords.stream().filter(c -> c.equals(coord)).findAny().isPresent();
				sb.append(isBlock ? "X" : " ");
			}
			sb.append("\n");
		}
		return sb.toString();
	}
}
