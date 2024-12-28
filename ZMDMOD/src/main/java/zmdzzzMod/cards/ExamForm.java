package zmdzzzMod.cards;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import zmdzzzMod.character.zmd;
import zmdzzzMod.powers.ExamFormPower;
import zmdzzzMod.powers.ExamPower;
import zmdzzzMod.powers.HomeworkPower;
import zmdzzzMod.util.CardStats;

public class ExamForm extends BaseCard {
    public static final String ID = makeID(ExamForm.class.getSimpleName());
    private static final CardStats info = new CardStats(
            zmd.Meta.CARD_COLOR,
            CardType.POWER,
            CardRarity.RARE,
            CardTarget.SELF,
            3
    );

//    private static final int DAMAGE = 1000;
//    private static final int UPG_DAMAGE = 3;
//    private static final int MAGIC=2;
//    private static final int UPG_MAGIC=2;

    public ExamForm() {
        super(ID, info);
        setCostUpgrade(1);
//        setMagic(MAGIC,UPG_MAGIC);
//        setDamage(DAMAGE, UPG_DAMAGE); //Sets the card's damage and how much it changes when upgraded.

//        tags.add(CardTags.STARTER_STRIKE);
//        tags.add(CardTags.STRIKE);

//        setExhaust(true);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, new ExamFormPower(AbstractDungeon.player, 1)));
        addToBot(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, new ExamPower(AbstractDungeon.player, 1)));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new ExamForm();
    }
}