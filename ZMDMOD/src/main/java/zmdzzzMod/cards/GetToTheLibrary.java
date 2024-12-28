package zmdzzzMod.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import zmdzzzMod.character.zmd;
import zmdzzzMod.powers.HomeworkPower;
import zmdzzzMod.util.CardStats;

public class GetToTheLibrary extends BaseCard {
    public static final String ID = makeID(GetToTheLibrary.class.getSimpleName());
    private static final CardStats info = new CardStats(
            zmd.Meta.CARD_COLOR,
            CardType.SKILL,
            CardRarity.COMMON,
            CardTarget.SELF,
            1
    );

//    private static final int DAMAGE = 1000;
//    private static final int UPG_DAMAGE = 3;
    private static final int MAGIC=1;
    private static final int UPG_MAGIC=1;

    public GetToTheLibrary() {
        super(ID, info);
//        setCostUpgrade(2);
        setMagic(MAGIC,UPG_MAGIC);
//        setDamage(DAMAGE, UPG_DAMAGE); //Sets the card's damage and how much it changes when upgraded.

//        tags.add(CardTags.STARTER_STRIKE);
//        tags.add(CardTags.STRIKE);

//        setExhaust(true);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot((AbstractGameAction)new GainBlockAction((AbstractCreature)p, (AbstractCreature)p, AbstractDungeon.player.hasPower(HomeworkPower.POWER_ID)? AbstractDungeon.player.getPower(HomeworkPower.POWER_ID).amount*magicNumber:0));
    }
//    public boolean canUse(AbstractPlayer p, AbstractMonster m) {
//        boolean canUse = true;
//        if(AbstractDungeon.player.gold<MAGIC) {
//            canUse = false;
//        }
//        return canUse;
//   }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new GetToTheLibrary();
    }
}