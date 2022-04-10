package com.nyrds.pixeldungeon.windows;

import static com.watabou.pixeldungeon.ui.Window.GAP;

import com.watabou.noosa.ColorBlock;
import com.watabou.noosa.Image;
import com.watabou.pixeldungeon.scenes.PixelScene;
import com.watabou.pixeldungeon.ui.ListItem;
import com.watabou.pixeldungeon.ui.Window;
import com.watabou.pixeldungeon.utils.Utils;

public class ChallengeItem extends ListItem {

    protected ColorBlock bg = new ColorBlock(width, height, 0xFF4A4D44);
    Image descIcon = new Image();

    HBox box = new HBox(100);

    ChallengeItem(Image icon, String title, Image _descIcon) {

        box.setAlign(HBox.Align.Width);
        box.setAlign(VBox.Align.Center);

        remove(sprite);
        remove(label);

        box.add(sprite);
        box.add(label);
        box.add(descIcon);

        sprite.copy(icon);
        label.text(title);
        descIcon.copy(_descIcon);

        add(bg);
        add(box);
    }

    @Override
    protected void layout() {
        box.setPos(x,y);
        bg.setX(box.left() - GAP);
        bg.setY(box.top() - GAP);
        bg.size(box.getMaxWidth() + 2 * GAP, box.height() + 2 * GAP);
    }

    @Override
    public void measure() {
        box.measure();
    }

    @Override
    protected void onClick() {

    }

    @Override
    public float width() {
        return box.width();
    }

    @Override
    public float height() {
        return box.height() + 4*GAP;
    }
}
