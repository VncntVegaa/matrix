def input_matrix():
    rows = int(input("Masukkan jumlah baris: "))
    cols = int(input("Masukkan jumlah kolom: "))

    matrix = []
    print("Masukkan elemen matriks:")

    for i in range(rows):
        row = list(map(int, input(f"Baris {i+1}: ").split()))
        matrix.append(row)

    return matrix


def print_matrix(matrix):
    print("\nMatriks:")
    for row in matrix:
        print(*row)
    print()


# 1. Sort Row Wise
def sort_row_wise(matrix):
    return [sorted(row) for row in matrix]


# 2. Sort Column Wise
def sort_column_wise(matrix):
    rows = len(matrix)
    cols = len(matrix[0])

    for j in range(cols):
        col = [matrix[i][j] for i in range(rows)]
        col.sort()

        for i in range(rows):
            matrix[i][j] = col[i]

    return matrix


# 3. Rotate Clockwise by 1
def rotate_clockwise_by_one(matrix):
    rows = len(matrix)
    cols = len(matrix[0])

    temp = matrix[0][0]

    for i in range(rows - 1):
        matrix[i][0] = matrix[i + 1][0]

    for j in range(cols - 1):
        matrix[rows - 1][j] = matrix[rows - 1][j + 1]

    for i in range(rows - 1, 0, -1):
        matrix[i][cols - 1] = matrix[i - 1][cols - 1]

    for j in range(cols - 1, 1, -1):
        matrix[0][j] = matrix[0][j - 1]

    matrix[0][1] = temp
    return matrix


# 4. Rotate Counter Clockwise by 1
def rotate_counter_clockwise_by_one(matrix):
    rows = len(matrix)
    cols = len(matrix[0])

    temp = matrix[0][0]

    for j in range(cols - 1):
        matrix[0][j] = matrix[0][j + 1]

    for i in range(rows - 1):
        matrix[i][cols - 1] = matrix[i + 1][cols - 1]

    for j in range(cols - 1, 0, -1):
        matrix[rows - 1][j] = matrix[rows - 1][j - 1]

    for i in range(rows - 1, 1, -1):
        matrix[i][0] = matrix[i - 1][0]

    matrix[1][0] = temp
    return matrix


# 5. Rotate 90 Derajat
def rotate_90(matrix):
    return [list(row) for row in zip(*matrix[::-1])]


# 6. Rotate 180 Derajat
def rotate_180(matrix):
    return [row[::-1] for row in matrix[::-1]]


# 7. Row Wise Traversal
def row_wise_traversal(matrix):
    print("Row-wise Traversal:")
    for row in matrix:
        for item in row:
            print(item, end=" ")
    print("\n")


# 8. Column Wise Traversal
def column_wise_traversal(matrix):
    print("Column-wise Traversal:")

    rows = len(matrix)
    cols = len(matrix[0])

    for j in range(cols):
        for i in range(rows):
            print(matrix[i][j], end=" ")

    print("\n")


# 9. Spiral Print
def spiral_print(matrix):
    print("Spiral Traversal:")

    top = 0
    bottom = len(matrix) - 1
    left = 0
    right = len(matrix[0]) - 1

    while top <= bottom and left <= right:

        for i in range(left, right + 1):
            print(matrix[top][i], end=" ")
        top += 1

        for i in range(top, bottom + 1):
            print(matrix[i][right], end=" ")
        right -= 1

        if top <= bottom:
            for i in range(right, left - 1, -1):
                print(matrix[bottom][i], end=" ")
            bottom -= 1

        if left <= right:
            for i in range(bottom, top - 1, -1):
                print(matrix[i][left], end=" ")
            left += 1

    print("\n")


# 10. Transpose Matrix
def transpose_matrix(matrix):
    return [list(row) for row in zip(*matrix)]


# =====================
# MAIN PROGRAM
# =====================

matrix_asli = input_matrix()

while True:
    print("===== MENU MATRIX =====")
    print("1. Sort Matrix Row-wise")
    print("2. Sort Matrix Column-wise")
    print("3. Rotate Matrix Clockwise by 1")
    print("4. Rotate Matrix Counter-Clockwise by 1")
    print("5. Rotate Matrix 90°")
    print("6. Rotate Matrix 180°")
    print("7. Row-wise Traversal")
    print("8. Column-wise Traversal")
    print("9. Print Matrix in Spiral Form")
    print("10. Transpose Matrix")
    print("11. Quit")

    choice = input("Pilih menu: ")

    if choice == "1":
        hasil = sort_row_wise([row[:] for row in matrix_asli])
        print_matrix(hasil)

    elif choice == "2":
        hasil = sort_column_wise([row[:] for row in matrix_asli])
        print_matrix(hasil)

    elif choice == "3":
        hasil = rotate_clockwise_by_one([row[:] for row in matrix_asli])
        print_matrix(hasil)

    elif choice == "4":
        hasil = rotate_counter_clockwise_by_one([row[:] for row in matrix_asli])
        print_matrix(hasil)

    elif choice == "5":
        hasil = rotate_90([row[:] for row in matrix_asli])
        print_matrix(hasil)

    elif choice == "6":
        hasil = rotate_180([row[:] for row in matrix_asli])
        print_matrix(hasil)

    elif choice == "7":
        row_wise_traversal(matrix_asli)

    elif choice == "8":
        column_wise_traversal(matrix_asli)

    elif choice == "9":
        spiral_print(matrix_asli)

    elif choice == "10":
        hasil = transpose_matrix([row[:] for row in matrix_asli])
        print_matrix(hasil)

    elif choice == "11":
        print("Program selesai.")
        break

    else:
        print("Pilihan tidak valid!")
