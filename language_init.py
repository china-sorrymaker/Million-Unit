import os

# 004 号项目：单位转换器词库
TRANSLATIONS = {
    "values": ["Million Unit", "Enter Meters", "Convert", "Kilometers: ", "Miles: ", "Feet: "],
    "values-zh-rCN": ["百万单位转换", "输入米(m)", "立即转换", "千米：", "英里：", "英尺："],
    "values-ja": ["ミリオン単位換算", "メートル入力", "換算", "キロメートル：", "マイル：", "フィート："]
}

# 对应：App名, 输入提示, 按钮, 结果标签1, 结果标签2, 结果标签3
KEYS = ["app_name", "hint_meter", "btn_convert", "res_km", "res_mile", "res_feet"]
BASE_PATH = "app/src/main/res"

def generate():
    for folder, values in TRANSLATIONS.items():
        target_dir = os.path.join(BASE_PATH, folder)
        os.makedirs(target_dir, exist_ok=True)
        content = '<?xml version="1.0" encoding="utf-8"?>\n<resources>\n'
        for i in range(len(KEYS)):
            content += f'    <string name="{KEYS[i]}">{values[i]}</string>\n'
        content += '</resources>'
        with open(os.path.join(target_dir, "strings.xml"), "w", encoding="utf-8") as f:
            f.write(content)
    print("✅ 004 号项目语言包生成成功")

if __name__ == "__main__":
    generate()
