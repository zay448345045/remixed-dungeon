---
--- Generated by EmmyLua(https://github.com/EmmyLua)
--- Created by mike.
--- DateTime: 25.03.19 0:06
---
local RPD  = require "scripts/lib/commonClasses"

local buff = require "scripts/lib/buff"


return buff.init{
    desc  = function ()
        return {
            icon          = 44,
            name          = "DieHardBuff_Name",
            info          = "DieHardBuff_Info",
        }
    end,

    act = function(self,buff)
        buff:detach()
    end,

    attachTo = function(self, buff, target)
        buff:spend(20)
        return true
    end,

    regenerationBonus = function(self, buff)
        return buff:level()
    end
}
