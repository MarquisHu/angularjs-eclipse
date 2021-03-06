/**
 *  Copyright (c) 2013-2014 Angelo ZERR.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  Contributors:
 *  Angelo Zerr <angelo.zerr@gmail.com> - initial API and implementation
 */
package org.eclipse.angularjs.internal.ui.preferences;

import org.eclipse.angularjs.internal.ui.AngularUIPlugin;
import org.eclipse.angularjs.internal.ui.style.IStyleConstantsForAngular;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.resource.ColorRegistry;
import org.eclipse.ui.PlatformUI;
import org.eclipse.wst.sse.ui.internal.preferences.ui.ColorHelper;

/**
 * Angular UI preferences constants.
 *
 */
public class PreferenceConstants {

	/**
	 * Returns the Angular UI preferences store.
	 * 
	 * @return the Angular UI preferences store.
	 */
	public static IPreferenceStore getPreferenceStore() {
		return AngularUIPlugin.getDefault().getPreferenceStore();
	}

	/**
	 * Initializes the given preference store with the default values.
	 */
	public static void initializeDefaultValues() {
		IPreferenceStore store = getPreferenceStore();
		ColorRegistry registry = PlatformUI.getWorkbench().getThemeManager()
				.getCurrentTheme().getColorRegistry();

		// HTML Style Preferences
		String NOBACKGROUNDBOLD = " | null | false"; //$NON-NLS-1$
		String JUSTITALIC = " | null | false | true"; //$NON-NLS-1$
		String JUSTBOLD = " | null | true | false"; //$NON-NLS-1$

		// SyntaxColoringPage
		String styleValue = ColorHelper.findRGBString(registry,
				IStyleConstantsForAngular.ANGULAR_EXPRESSION_BORDER, 0, 0, 128)
				+ JUSTBOLD;
		store.setDefault(IStyleConstantsForAngular.ANGULAR_EXPRESSION_BORDER,
				styleValue);

		styleValue = " null|"
				+ ColorHelper.findRGBString(registry,
						IStyleConstantsForAngular.ANGULAR_EXPRESSION, 232, 235,
						255) + " | false | false";
		store.setDefault(IStyleConstantsForAngular.ANGULAR_EXPRESSION,
				styleValue);

		styleValue = ColorHelper.findRGBString(registry,
				IStyleConstantsForAngular.ANGULAR_DIRECTIVE_NAME, 0, 0, 128)
				+ JUSTBOLD;
		store.setDefault(IStyleConstantsForAngular.ANGULAR_DIRECTIVE_NAME,
				styleValue);

		styleValue = ColorHelper.findRGBString(registry,
				IStyleConstantsForAngular.ANGULAR_DIRECTIVE_PARAMETER_NAME, 14,
				140, 145)
				+ JUSTBOLD;
		store.setDefault(
				IStyleConstantsForAngular.ANGULAR_DIRECTIVE_PARAMETER_NAME,
				styleValue);

		// Enable highlighting
		store.setDefault(
				AngularUIPreferenceNames.HIGHLIGHTING_DIRECTIVE_ENABLED, true); //$NON-NLS-1$
		store.setDefault(
				AngularUIPreferenceNames.HIGHLIGHTING_EXPRESSION_ENABLED, true); //$NON-NLS-1$

		// Defaults for the Typing preference page
		store.setDefault(AngularUIPreferenceNames.TYPING_COMPLETE_END_EL, true);

	}
}
