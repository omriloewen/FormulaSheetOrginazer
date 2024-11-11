import matplotlib.pyplot as plt

# נוסחת LaTeX לדוגמה
latex_formula = r"$\frac{x^2 + y}{y}$"

# יצירת דמות להצגת הנוסחה
plt.figure(figsize=(4, 2))
plt.text(0.5, 0.5, latex_formula, fontsize=20, ha='center', va='center')

# הסתרת הצירים
plt.axis('off')
plt.show()