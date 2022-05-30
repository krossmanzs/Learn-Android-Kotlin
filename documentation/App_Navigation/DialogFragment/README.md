# DialogFragment
A `DialogFragment` is a special fragment subclass that is designed for creating and hosting `dialogs`
. Strictly speaking, you do not need to host your dialog within a fragment, but doing so allows
`FragmentManager` to manage the state of the dialog and automatically restore the dialog when
a configuration change occurs.

**More at [Displaying dialogs with DialogFragment](https://developer.android.com/guide/fragments/dialogs#kotlin)**