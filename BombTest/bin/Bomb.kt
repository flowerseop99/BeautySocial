import java.util.Random

val B_COUNT: Int = 10
val G_SIZE: Int = 10
val random = Random()

var G_ARRAY = Array(G_SIZE, {Array(G_SIZE, {"0"})})

fun main(args: Array<String>) {
	
	
	if(B_COUNT > G_SIZE * G_SIZE) {
		println("오류 : 지뢰의 숫자가 너무 많습니다");
		return
	}

	setBombLoc(0)	//지뢰 설치
	
	//지뢰 갯수 탐색
	for(i in 0 until G_SIZE) {
		for(j in 0 until G_SIZE) {
			if(!G_ARRAY[i][j].equals("*"))
				cntBomb(i, j)
		}
	}

	//사각형 출력
	for(i in G_ARRAY) {
		for(j in i) {
			if(j.equals("0"))
				print("[ ]")
			else
				print("["+j+"]")
		}
		println()
	}
	
	
}
fun setBombLoc(bcnt: Int) {
	var a = random.nextInt(10)
	var b = random.nextInt(10)
	var cnt = bcnt
		
	
	if(!G_ARRAY[a][b].equals("*")) {
		G_ARRAY[a][b] = "*"
		cnt++
	}
	
	if(cnt == B_COUNT) {
		return 
	}else {
		setBombLoc(cnt)
	}
}

fun cntBomb(x : Int, y : Int) {
	for(i in (x - 1)..(x + 1)){
		for(j in (y - 1)..(y + 1)) {
			if(i>=0 && i<G_SIZE && j>=0 && j<G_SIZE && G_ARRAY[i][j].equals("*")) {
				var temp = G_ARRAY[x][y].toInt()
				temp++
				G_ARRAY[x][y] =  temp.toString()
			}
		}
	}
}