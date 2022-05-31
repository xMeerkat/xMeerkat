/*
 * Copyright (c) 2022, xMeerkat.com
 * All rights reserved.
 */

package xms.website.profile

import xms.profiles.AccType
import xms.profiles.Profile

object profileWidget {



    @JvmStatic fun make (profile : Profile) : String {

        var builder : StringBuilder = StringBuilder()

        when (profile.accType) {
            AccType.GENERATED -> builder.append(GENERATED(profile))
            AccType.NORMAL -> builder.append(NORMAL(profile))
            AccType.PREMIUM -> builder.append(PREMIUM(profile))
            AccType.VERIFIED_ACCOUNT -> builder.append(VERIFIED_ACCOUNT(profile))
            AccType.VERIFIED_MODERATOR -> builder.append(VERIFIED_MODERATOR(profile))
            AccType.VERIFIED_DOMAIN_OWNER -> builder.append(VERIFIED_DOMAIN_OWNER(profile))
        }


        val end : String = """
            <p class="BlueBoy">
		        <a class="BlueBoy" href = "/user/${profile.username}">
			        @${profile.username}
		        </a>
	        </p>
        """.trimIndent()

        builder.append(end)

        return builder.toString()
    }




    @JvmStatic fun GENERATED (profile : Profile) : String {

        val PROFILE : String = """
            <h4 align="left">
                <p class="ProfilePFPp">
		            <img id="ProfilePFP" class="ProfilePFP" src="https://raw.githubusercontent.com/xMeerkat/official-assets/master/assets/verifyWithJS.png"/> <!-- https://en.wikipedia.org/wiki/List_of_common_resolutions -->
		            &nbsp;
                    <text class="VerifiedGen">${profile.name}</text>
                    <img class="ProfilePFPv" src="https://raw.githubusercontent.com/xMeerkat/official-assets/master/assets/GENERATED.png"/> 
                </p>
	        </h4>

            <p class="VerifiedGen">
                This account was generated from a video.
            </p>
            """.trimIndent()

        return PROFILE
    }


    @JvmStatic fun NORMAL (profile : Profile) : String {

        val PROFILE : String = """
            <h4 align="left">
                <p class="ProfilePFPp">
		            <img id="ProfilePFP" class="ProfilePFP" src="https://raw.githubusercontent.com/xMeerkat/official-assets/master/assets/verifyWithJS.png"/> <!-- https://en.wikipedia.org/wiki/List_of_common_resolutions -->
		            &nbsp;
                    ${profile.name}
                </p>
	        </h4>
            """.trimIndent()

        return PROFILE
    }


    @JvmStatic fun PREMIUM (profile : Profile) : String {

        val PROFILE : String = """
            <h4 align="left">
                <p class="ProfilePFPp">
		            <img id="ProfilePFP" class="ProfilePFP" src="https://raw.githubusercontent.com/xMeerkat/official-assets/master/assets/verifyWithJS.png"/> <!-- https://en.wikipedia.org/wiki/List_of_common_resolutions -->
		            &nbsp;
                    <text class="VerifiedPremium">${profile.name}</text>
                    <img class="ProfilePFPv" src="https://raw.githubusercontent.com/xMeerkat/official-assets/master/assets/PREMIUM.png"/> 
                </p>
	        </h4>

            <p class="VerifiedPremium">
                xMeerkat Premium
            </p>
            """.trimIndent()

        return PROFILE
    }

    @JvmStatic fun VERIFIED_ACCOUNT (profile : Profile) : String {

        val PROFILE : String = """
            <h4 align="left">
                <p class="ProfilePFPp">
		            <img id="ProfilePFP" class="ProfilePFP" src="https://raw.githubusercontent.com/xMeerkat/official-assets/master/assets/verifyWithJS.png"/> <!-- https://en.wikipedia.org/wiki/List_of_common_resolutions -->
		            &nbsp;
                    <text class="VerifiedAcc">${profile.name}</text>
                    <img class="ProfilePFPv" src="https://raw.githubusercontent.com/xMeerkat/official-assets/master/assets/Verified.png"/>
                </p>
	        </h4>

            <p class="VerifiedAcc">
                Verified Account
            </p>
            """.trimIndent()

        return PROFILE
    }


    @JvmStatic fun VERIFIED_MODERATOR (profile : Profile) : String {

    val PROFILE : String = """
            <h4 align="left">
                <p class="ProfilePFPp">
		            <img id="ProfilePFP" class="ProfilePFP" src="https://raw.githubusercontent.com/xMeerkat/official-assets/master/assets/verifyWithJS.png"/> <!-- https://en.wikipedia.org/wiki/List_of_common_resolutions -->
		            &nbsp;
                    <text class="VerifiedMod">${profile.name}</text>
                    <img class="ProfilePFPv" src="https://raw.githubusercontent.com/xMeerkat/official-assets/master/assets/MODERATOR.png"/>
                </p>
	        </h4>

            <p class="VerifiedMod">
                Verified Moderator
            </p>
            """.trimIndent()

    return PROFILE
    }


    @JvmStatic fun VERIFIED_DOMAIN_OWNER (profile : Profile) : String {

        val PROFILE : String = """
            <h4 align="left">
                <p class="ProfilePFPp">
		            <img id="ProfilePFP" class="ProfilePFP" src="https://raw.githubusercontent.com/xMeerkat/official-assets/master/assets/verifyWithJS.png"/> <!-- https://en.wikipedia.org/wiki/List_of_common_resolutions -->
		            &nbsp;
                    <text class="VerifiedDom">${profile.name}</text>
                    <img class="ProfilePFPd" src="https://raw.githubusercontent.com/xMeerkat/official-assets/master/assets/DOMAIN.png"/>
                </p>
	        </h4>

            <p class="VerifiedDom">
                Verified Domain Owner
            </p>
            """.trimIndent()

        return PROFILE
    }

}