import numpy as np
import matplotlib.pyplot as plt
import random
from rectpack import newPacker, PackingBin
import rectpack


class Item:
    def __init__(self, widths, heights, level, id):
        self.widths = widths
        self.heights = heights
        self.selectedRatio = 0;
        self.level = level;
        self.id = id

    def shape(self, fontSize):
        return (self.heights[self.selectedRatio] * fontSize, self.widths[self.selectedRatio] * fontSize)
    
    def score(self, fontSize):
        return ((5 - self.selectedRatio)/ 5) * fontSize * (5 - self.level)
    
def packRects(rects, container):
    packer = newPacker(rotation=False, pack_algo=rectpack.MaxRectsBlsf, sort_algo=rectpack.SORT_DIFF)
    packer.add_bin(container[0],container[1])
    for rect in rects:
        packer.add_rect(*rect[0], rid=rect[1])
        
    packer.pack()
    return packer

def get_base_bounding(rects):
    packer = newPacker(rotation=False, pack_algo=rectpack.MaxRectsBlsf, sort_algo=rectpack.SORT_DIFF)
    packer.add_bin(1000,1000)
    for rect in rects:
        packer.add_rect(*rect[0], rid=rect[1])
    packer.pack()
    return calc_bounding(packer)
    
    
 
 
def visualize_pack(packer):
    plt.figure(figsize=(10, 10))
    plt.xlim(0, packer.bin_list()[0][0])
    plt.ylim(0, packer.bin_list()[0][1])
    
    # ציור המלבנים
    for rect in packer.rect_list():
        plt.gca().add_patch(plt.Rectangle((rect[1], rect[2]), rect[3], rect[4], fill=True, edgecolor='black', alpha=0.5))
        plt.text(rect[1] + rect[3]/2, rect[2] + rect[4]/2, f'ID: {rect[5]}', ha='center', va='center')

    plt.title("Packing Visualization")
    plt.xlabel("Width")
    plt.ylabel("Height")
    plt.grid(True)
    plt.gca().set_aspect('equal', adjustable='box')
    plt.show()
    
def validate_packer(packer, rects):
    packed_rectangles = sum(len(b) for b in packer)  # סופרים את מספר המלבנים הממוקמים
    total_rectangles = len(rects)
    if packed_rectangles < total_rectangles:
        print(f"לא ניתן למקם את כל המלבנים במלבן הגדול. הוצבו {packed_rectangles} מתוך {total_rectangles}.")
        return False
    else:
        return True
    
def calc_bounding(packer):
    min_x = float('inf')
    min_y = float('inf')
    max_x = float('-inf')
    max_y = float('-inf')
 
    # עובר על כל המלבנים
    for b in packer.rect_list():
        x, y, w, h = b[1], b[2], b[3], b[4]
        min_x = min(min_x, x)
        min_y = min(min_y, y)
        max_x = max(max_x, x + w)
        max_y = max(max_y, y + h)

    # רוחב וגובה המלבן המוקף
    bounding_width = max_x - min_x
    bounding_height = max_y - min_y
    return(bounding_width,bounding_height)
    

       
    
    
Items = [Item(np.random.uniform(0.5,4,random.randint(1,5)),np.random.uniform(0.5,4,5), random.randint(0,4), i) for i in range(20)]
fontSizes = [20 for _ in range(5)]

scores = np.array([item.score(fontSizes[item.level]) for item in Items])
print(scores)
j = 0
while fontSizes[4] != 8 :
    fontSizes[j] -= 1
    j = (j+1)%5
    
    print(np.array([item.score(fontSizes[item.level]) for item in Items]))
    packer = packRects([(item.shape(fontSizes[item.level]), item.id)for item in Items], (500,500))
    if(validate_packer(packer, Items)):
        visualize_pack(packer)
        break
    
    

    

