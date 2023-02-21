import tkinter as tk

def solve():
    # get the values from the Entry widgets
    a = int(entry1.get())
    b = int(entry2.get())
    c = int(entry3.get())

    # solve the equation
    x = (b**2 - 4*a*c) / (2*a)

    # display the result
    label4.config(text="Result: " + str(x))

# create the main window
root = tk.Tk()
root.title("Math Problem Solver")

# create the Entry widgets
entry1 = tk.Entry(root)
entry2 = tk.Entry(root)
entry3 = tk.Entry(root)

# create the labels
label1 = tk.Label(root, text="a:")
label2 = tk.Label(root, text="b:")
label3 = tk.Label(root, text="c:")
label4 = tk.Label(root, text="")

# place the Entry widgets and labels in the window
entry1.grid(row=0, column=1)
entry2.grid(row=1, column=1)
entry3.grid(row=2, column=1)
label1.grid(row=0, column=0)
label2.grid(row=1, column=0)
label3.grid(row=2, column=0)
label4.grid(row=3, column=0, columnspan=2)

# create the solve button
button = tk.Button(root, text="Solve", command=solve)
button.grid(row=4, column=0, columnspan=2, pady=10)

# start the main loop
root.mainloop()
